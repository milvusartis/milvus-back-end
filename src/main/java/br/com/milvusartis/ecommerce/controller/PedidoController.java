//package br.com.milvusartis.ecommerce.controller;
//
//import br.com.milvusartis.ecommerce.service.PedidoService;
//import br.com.milvusartis.ecommerce.model.entity.Cliente;
//import br.com.milvusartis.ecommerce.model.entity.Pedido;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class PedidoController {
//
//    @Autowired
//    PedidoService pedidoService;
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/pedido")
//    public ResponseEntity  save(@RequestBody Pedido pd) {
//        return ResponseEntity.ok().body(pedidoService.cadastrarPedido(pd));
//    }
//
//    @GetMapping("/pedido")
//    public ResponseEntity buscarLista(Long id, String st, Cliente cl) {
//        return ResponseEntity.ok().body(pedidoService.buscarPedido(id, st, cl));
//    }
//
//    @GetMapping("/pedidos")
//    public ResponseEntity buscarTodos() {
//        return ResponseEntity.ok().body(pedidoService.buscarTodosOsPedidos());
//    }
//
//    @PutMapping("/pedido")
//    public ResponseEntity alterar(@RequestBody Pedido pd) {
//        return ResponseEntity.ok().body(pedidoService.alterarPedido(pd));
//    }
//
//    @DeleteMapping("/pedido")
//    public void deletar(Long id) {
//        pedidoService.deletarPedido(id);
//    }
//
//}
