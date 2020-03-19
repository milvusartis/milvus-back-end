package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.service.PedidoItemService;
import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoItemController {

    @Autowired
    PedidoItemService pedidoItemService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/item")
    public ResponseEntity save(@RequestBody PedidoItem it) {
        return ResponseEntity.ok().body(pedidoItemService.cadastrarPedidoItem(it));
    }

    @GetMapping("/item")
    public ResponseEntity buscarLista(Long id) {
        return ResponseEntity.ok().body(pedidoItemService.buscarPedidoItem(id));
    }

    @PutMapping("/item")
    public ResponseEntity alterar(@RequestBody PedidoItem it) {
        return ResponseEntity.ok().body(pedidoItemService.alterarPedidoItem(it));
    }

    @DeleteMapping("/item")
    public void deletar(Long id) {
        pedidoItemService.deletarPedidoItem(id);
    }

//    @GetMapping("/itenspedido")
//    public ResponseEntity buscarListaItens(Long id) {
//        return ResponseEntity.ok().body(pedidoItemService.buscarItensDoPedido(id));
//    }

}