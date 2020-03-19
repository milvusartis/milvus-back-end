package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import br.com.milvusartis.ecommerce.repository.PedidoItemRepository;
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
public class PedidoItemService {

    @Autowired
    PedidoItemRepository pedidoItemRepository;
    PedidoRepository pedidoRepository;

    public ResponseEntity cadastrarPedidoItem(PedidoItem pedidoItem) {

        PedidoItem pedidoItemEntity = new PedidoItem();

        if(pedidoItem != null)
            pedidoItemEntity = pedidoItemRepository.save(pedidoItem);

        if(pedidoItemEntity != null)
            return ResponseEntity.ok().body(pedidoItemEntity);
        else
            return ResponseEntity.badRequest().build();

    }

    public ResponseEntity buscarPedidoItem(@PathParam("nr_item_pedido") Long nrItemPedido) {

        List<PedidoItem> pedidoItem = new ArrayList<>();

        if (nrItemPedido != null)
            pedidoItem.add(pedidoItemRepository.findById(nrItemPedido).get());

        if (pedidoItem != null && pedidoItem.size() > 0)
            return ResponseEntity.ok().body(pedidoItem);
        else
            return ResponseEntity.badRequest().build();

    }

    public ResponseEntity buscarTodosOsPedidosItens() {

        List<PedidoItem> pedidoItem = pedidoItemRepository.findAll();

        if (pedidoItem != null && pedidoItem.size() > 0)
            return ResponseEntity.ok().body(pedidoItem);
        else
            return ResponseEntity.badRequest().build();
    }

    public ResponseEntity alterarPedidoItem(@RequestBody PedidoItem pedidoItem) {

        PedidoItem pedidoItemEntity = new PedidoItem();

        if(pedidoItem != null)
            pedidoItemEntity = pedidoItemRepository.getOne(pedidoItem.getNrItemPedido());

            pedidoItemEntity.setVlProduto(pedidoItem.getVlProduto());
            pedidoItemEntity.setNrQuantidade(pedidoItem.getNrQuantidade());

        if(pedidoItemEntity != null)
            return ResponseEntity.ok().body(pedidoItemRepository.save(pedidoItemEntity));
        else
            return ResponseEntity.badRequest().build();
    }

    public void deletarPedidoItem(@PathVariable("nr_item_pedido") Long nrItemPedido) {
        pedidoItemRepository.deleteById(nrItemPedido);
    }


//    public ResponseEntity buscarItensDoPedido(@PathParam("id_pedido")Long idPedido) {
//        Pedido pedido = new Pedido();
//        List<PedidoItem> pedidoItem = new ArrayList<>();
//        List<PedidoItem> todosItens = pedidoItemRepository.findAll();
//
//        if(idPedido != null)
//            pedido = pedidoRepository.findById(idPedido).get();
//
//        for(Integer i = 0; i < todosItens.size(); i++)
//            if(pedido != null)
//                pedidoItem.add(pedidoRepository.findByPedido(pedido));
//
//        if(pedidoItem != null && pedidoItem.size() > 0)
//            return ResponseEntity.ok().body(pedidoItem);
//        else
//            return ResponseEntity.badRequest().build();
//
//    }

}
