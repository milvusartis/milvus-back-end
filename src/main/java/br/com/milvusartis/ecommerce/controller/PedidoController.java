package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.AuthorizationException;
import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.PedidoBO;
import br.com.milvusartis.ecommerce.model.dto.PedidoDTO;
import br.com.milvusartis.ecommerce.model.dto.PedidoRequestDTO;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import br.com.milvusartis.ecommerce.security.UserSS;
import br.com.milvusartis.ecommerce.service.PedidoService;
import br.com.milvusartis.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    PedidoBO pedidoBO;

    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping("/pedidos")
    public ResponseEntity<?> cadastrar(@RequestBody PedidoRequestDTO pedidoRequestDTO) {

        if (pedidoRequestDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não pode estar vazio");
        }


        UserSS user = UsuarioService.authenticated();

        if(user == null){
            throw new AuthorizationException("Acesso negado");
        }

        Optional<Usuario> opt_cliente = usuarioRepository.findById(user.getId());
        Usuario usuario = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        pedidoRequestDTO.setUsuario(usuario);

       Pedido pedido =  pedidoService.inicializaPedido(pedidoRequestDTO);

        Pedido pedidoEntity = pedidoRepository.save(pedido);

        pedidoService.enviaEmailAprovacao(pedidoEntity);

        pedidoService.confirmaPagamento(pedidoEntity, pedidoRequestDTO.getCartao());

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoBO.parseToDTO(pedidoEntity));


    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/pedidos")
    public ResponseEntity<?> listar() {

        List<Pedido> listaPedidos = pedidoRepository.findAll();
        List<PedidoDTO> listaDePedidosResposta = new ArrayList<>();

        listaPedidos.forEach((pedido) -> {
            listaDePedidosResposta.add(pedidoBO.parseToDTO(pedido));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDePedidosResposta);

    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Pedido> opt_pedido = pedidoRepository.findById(id);
        Pedido pedido = opt_pedido.orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(pedidoBO.parseToDTO(pedido));

    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/pedidos/{id}/{acao}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @PathVariable("acao") String acao) {

        System.out.println(acao);
        Optional<Pedido> opt_pedido = pedidoRepository.findById(id);
        Pedido pedido = opt_pedido.orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        Pedido pedidoEntity;

        switch (acao){
            case "aprovar":
                pedidoEntity = pedidoRepository.save(pedidoService.aprovarPedido(pedido));
                pedidoService.enviaEmailAprovacao(pedidoEntity);
                break;
            case "entregar":
                //TODO fazer execeção caso tente entregar um pedido não aprovado
                    pedidoEntity = pedidoRepository.save(pedidoService.entregarPedido(pedido));
                    pedidoService.enviaEmailAprovacao(pedidoEntity);
                break;
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoBO.parseToDTO(pedido));

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {

        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedidoRepository.delete(pedido);
                    return ResponseEntity.status(HttpStatus.OK).body("Pedido excluído");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}