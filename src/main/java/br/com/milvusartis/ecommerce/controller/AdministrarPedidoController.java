package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.bo.PedidoBO;
import br.com.milvusartis.ecommerce.model.dto.PedidoDTO;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdministrarPedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoBO pedidoBO;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/pedidos/{statusPedido}")
    public ResponseEntity<?> listarPorStatus(@PathVariable("statusPedido") StatusPedido statusPedido) {

        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(statusPedido);

        List<PedidoDTO> pedidosDTO = pedidos
                .stream()
                .map(pedido -> pedidoBO.parseToDTO(pedido))
                .collect((Collectors.toList()));

        return ResponseEntity.status(HttpStatus.OK).body(pedidosDTO);
    }

}