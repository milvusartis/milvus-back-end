package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity cadastrarPedido(Pedido pedido) {

        Pedido pedidoEntity = new Pedido();

        if(pedido != null)
            pedidoEntity = pedidoRepository.save(pedido);

        if(pedidoEntity != null)
            return ResponseEntity.ok().body(pedidoEntity);
        else
            return ResponseEntity.badRequest().build();
    }

    public ResponseEntity buscarPedido(@PathParam("nr_pedido") Long numero,
                                       @PathParam("ds_status_pedido") String statusPedido,
                                       @PathParam("id_cliente") Cliente cliente) {

        List<Pedido> pedido = new ArrayList<>();

        if (statusPedido != null)
            pedido = pedidoRepository.findByStatusPedido(statusPedido);
        else if (numero != null)
            pedido = pedidoRepository.findByNumero(numero);
        else if (cliente != null)
            pedido = pedidoRepository.findByCliente(cliente);
        else if (statusPedido != null && cliente != null)
            pedido = pedidoRepository.findByClienteAndStatusPedido(cliente, statusPedido);

        if (pedido != null && pedido.size() > 0)
            return ResponseEntity.ok().body(pedido);
        else
            return ResponseEntity.badRequest().build();

    }

    public ResponseEntity buscarTodosOsPedidos() {

        List<Pedido> pedido = pedidoRepository.findAll();

        if (pedido != null && pedido.size() > 0)
            return ResponseEntity.ok().body(pedido);
        else
            return ResponseEntity.badRequest().build();
    }

    public ResponseEntity alterarPedido(@RequestBody Pedido pedido) {

        Pedido pedidoEntity = new Pedido();

        if(pedido != null)
            pedidoEntity = pedidoRepository.getOne(pedido.getIdPedido());

            pedidoEntity.setNumero(pedido.getNumero());
            pedidoEntity.setDtPedido(pedido.getDtPedido());
            pedidoEntity.setVlFrete(pedido.getVlFrete());
            pedidoEntity.setStatusPedido(pedido.getStatusPedido());
            pedidoEntity.setVlTotal(pedido.getVlTotal());
            pedidoEntity.setNrCartao(pedido.getNrCartao());
            pedidoEntity.setNmCartao(pedido.getNmCartao());
            pedidoEntity.setDtValidadeCartao(pedido.getDtValidadeCartao());
            pedidoEntity.setCdSegurancaCartao(pedido.getCdSegurancaCartao());
            pedidoEntity.setDtEntrega(pedido.getDtEntrega());

        if(pedidoEntity != null)
            return ResponseEntity.ok().body(pedidoRepository.save(pedidoEntity));
        else
            return ResponseEntity.badRequest().build();
    }

    public void deletarPedido(@PathVariable("id_pedido") Long id) {
        pedidoRepository.deleteById(id);
    }

}
