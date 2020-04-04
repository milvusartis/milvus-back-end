package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdministrarPedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("pedidos/{statusPedido}")
    public List<Pedido> filtrarPedidos(StatusPedido statusPedido) {

        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(statusPedido);

        return pedidos;
    }

}