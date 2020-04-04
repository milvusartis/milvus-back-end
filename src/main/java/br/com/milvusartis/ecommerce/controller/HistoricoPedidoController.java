package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.PedidoBO;
import br.com.milvusartis.ecommerce.model.dto.PedidoDTO;
import br.com.milvusartis.ecommerce.model.dto.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
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
    PedidoBO pedidoBO;

    @GetMapping("lista-pedidos/{idCliente}")
    public ResponseEntity<?> listarTodos(@PathVariable("idCliente") Long idCliente) {

        Optional<Cliente> opt_cliente = clienteRepository.findById(idCliente);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        List<Pedido> pedidosCliente = pedidoRepository.findByCliente(cliente);

        List<PedidoDTO> pedidosClienteDTO = pedidosCliente
                .stream()
                .map(pedido -> pedidoBO.parseToDTO(pedido))
                .collect((Collectors.toList()));

        return ResponseEntity.status(HttpStatus.OK).body(pedidosClienteDTO);

    }

    @GetMapping("lista-pedidos/{idCliente}/{statusPedido}")
    public ResponseEntity<?> listarPorStatus(@PathVariable("idCliente") Long idCliente,
                                             @PathVariable("statusPedido") StatusPedido statusPedido) {

        Optional<Cliente> opt_cliente = clienteRepository.findById(idCliente);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        List<Pedido> pedidosClienteStatus = pedidoRepository.findByClienteAndStatusPedido(cliente, statusPedido);

        List<PedidoDTO> pedidosClienteStatusDTO = pedidosClienteStatus
                .stream()
                .map(pedido -> pedidoBO.parseToDTO(pedido))
                .collect((Collectors.toList()));

        return ResponseEntity.status(HttpStatus.OK).body(pedidosClienteStatusDTO);

    }
}
