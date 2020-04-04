package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.PedidoResponseBO;
import br.com.milvusartis.ecommerce.model.dto.PedidoResponseDTO;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import br.com.milvusartis.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    PedidoResponseBO pedidoResponseBO;

    @PostMapping("/pedidos")
    public ResponseEntity<?> cadastrar(@RequestBody PedidoResponseDTO pedidoResponseDTO) {

        if (pedidoResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não pode estar vazio");
        }

        Pedido pedido = pedidoResponseBO.parseToPOJO(pedidoResponseDTO);

        pedidoService.inicializaPedido(pedido);

        Pedido pedidoEntity = pedidoRepository.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponseBO.parseToDTO(pedidoEntity));

    }

    @GetMapping("/pedidos")
    public ResponseEntity<?> listar() {

        List<Pedido> listaPedidos = pedidoRepository.findAll();
        List<PedidoResponseDTO> listaDePedidosResposta = new ArrayList<>();

        listaPedidos.forEach((pedido) -> {
            listaDePedidosResposta.add(pedidoResponseBO.parseToDTO(pedido));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDePedidosResposta);

    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Pedido> opt_pedido = pedidoRepository.findById(id);
        Pedido pedido = opt_pedido.orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponseBO.parseToDTO(pedido));

    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {

        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedidoRepository.delete(pedido);
                    return ResponseEntity.status(HttpStatus.OK).body("Pedido excluído");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}