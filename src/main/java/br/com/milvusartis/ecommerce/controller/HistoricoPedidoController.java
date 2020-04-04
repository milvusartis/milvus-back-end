package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HistoricoPedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("pedidos/{idCliente}")
    public List<Pedido> listarTodos(@PathVariable("idCliente") Long idCliente) {

        Optional<Cliente> opt_cliente = clienteRepository.findById(idCliente);

        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        List<Pedido> pedidosCliente = pedidoRepository.findByCliente(cliente);

        return pedidosCliente;
    }

    @GetMapping("pedidos/{idCliente}/{statusPedido}")
    public List<Pedido> listarPorStatus(@PathVariable("idCliente") Long idCliente,
                                        @PathVariable("statusPedido") StatusPedido statusPedido) {

        Optional<Cliente> opt_cliente = clienteRepository.findById(idCliente);

        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        List<Pedido> pedidosClienteStatus = pedidoRepository.findByClienteAndStatusPedido(cliente, statusPedido);

        return pedidosClienteStatus;

    }
}
