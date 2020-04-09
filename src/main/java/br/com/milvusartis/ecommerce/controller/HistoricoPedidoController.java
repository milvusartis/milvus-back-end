package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.PedidoBO;
import br.com.milvusartis.ecommerce.model.dto.PedidoDTO;
import br.com.milvusartis.ecommerce.model.dto.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class HistoricoPedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Autowired
    PedidoBO pedidoBO;

    @GetMapping("historico-pedidos/{idUsuario}")
    public ResponseEntity<?> listarTodos(@PathVariable("idUsuario") Long idUsuario) {

        Optional<Usuario> opt_cliente = usuarioRepository.findById(idUsuario);
        Usuario usuario = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Uaurio não encontrado"));

        Cliente cliente = clienteRepository.findByUsuario(usuario);

        List<Pedido> pedidosCliente = pedidoRepository.findByCliente(cliente);

        List<PedidoDTO> pedidosClienteDTO = pedidosCliente
                .stream()
                .map(pedido -> pedidoBO.parseToDTO(pedido))
                .collect((Collectors.toList()));

        return ResponseEntity.status(HttpStatus.OK).body(pedidosClienteDTO);

    }

    @GetMapping("historico-pedidos/{idUsuario}/{statusPedido}")
    public ResponseEntity<?> listarPorStatus(@PathVariable("idUsuario") Long idUsuario,
                                             @PathVariable("statusPedido") StatusPedido statusPedido) {

        Optional<Usuario> opt_cliente = usuarioRepository.findById(idUsuario);
        Usuario usuario = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Uaurio não encontrado"));

        Cliente cliente = clienteRepository.findByUsuario(usuario);

        List<Pedido> pedidosClienteStatus = pedidoRepository.findByClienteAndStatusPedido(cliente, statusPedido);

        List<PedidoDTO> pedidosClienteStatusDTO = pedidosClienteStatus
                .stream()
                .map(pedido -> pedidoBO.parseToDTO(pedido))
                .collect((Collectors.toList()));

        return ResponseEntity.status(HttpStatus.OK).body(pedidosClienteStatusDTO);

    }
}
