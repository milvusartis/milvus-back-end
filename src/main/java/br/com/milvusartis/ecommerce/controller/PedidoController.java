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
    public ResponseEntity<List<Pedido>> findById(@PathParam("nr_pedido") Long nr,
                                                 @PathParam("ds_status_pedido") String ds) {

        List<Pedido> pedido = new ArrayList<>();


        if (nr != null && ds != null)
            pedido = pedidoRepository.findByNrPedidoAndDsStatusPedido(nr, ds);
        else if (ds != null)
            pedido = pedidoRepository.findByDsStatusPedido(ds);
        else if (nr != null)
            pedido = pedidoRepository.findByNrPedido(nr);

        if (pedido != null && pedido.size() > 0)
            return ResponseEntity.ok().body(pedido);
        else
            return ResponseEntity.badRequest().build();

    }
}
