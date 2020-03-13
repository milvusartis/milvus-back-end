package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.Pedido;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pedido")
    public Pedido save (@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> findById(@PathParam("id_pedido") Long id,
                                                 @PathParam("nr_pedido") Integer nr) {

        List<Pedido> pedido = new ArrayList<>();


        if (id != null && nr != null)
            pedido = pedidoRepository.findByIdPedidoAndNrPedido(id, nr);
        else if (id != null)
            pedido.add(pedidoRepository.findById(id).get());
        else if (pedido != null)
            pedido = pedidoRepository.findByNrPedido(nr);

        if (pedido != null && pedido.size() > 0)
            return ResponseEntity.ok().body(pedido);
        else
            return ResponseEntity.badRequest().build();

    }
}
