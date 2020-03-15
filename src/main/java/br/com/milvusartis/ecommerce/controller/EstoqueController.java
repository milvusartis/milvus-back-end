package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.DTO.EstoqueDTO;
import br.com.milvusartis.ecommerce.model.DTO.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.Estoque;
import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EstoqueController {


    @Autowired
    private EstoqueService service;


//    @PostMapping("/estoque")
//    public ResponseEntity<EstoqueDTO> salvar(@RequestBody EstoqueDTO estoqueDTO) {
//
//        System.out.println("ID:::"+estoqueDTO.getId());
//        System.out.println("PR:::"+estoqueDTO.getProduto());
//        System.out.println("QT:::"+estoqueDTO.getQtdestoque());
//        Estoque e = estoqueDTO.trasnsformaParaEstoque();
//        System.out.printf("SOU O ESTOQUE"+e);
//
//        Estoque estoque = service.salvar(estoqueDTO.trasnsformaParaEstoque());
//        return ResponseEntity.ok().body(EstoqueDTO.transformaEmDTO(estoque));
//    }
//
//
//    @GetMapping("/estoque")
//    public ResponseEntity<List<EstoqueDTO>> listar() {
//        List<Estoque> estoques = service.listar();
//        List<EstoqueDTO> listaDTO = new ArrayList<>();
//
//        for (Estoque e :  estoques){
//            EstoqueDTO dto = EstoqueDTO.transformaEmDTO(e);
//            listaDTO.add(dto);
//        }
//        return ResponseEntity.ok().body(listaDTO);
//    }
//
//    @GetMapping("/estoque/{id}")
//    public ResponseEntity<EstoqueDTO> buscarEstoquePorID(@PathVariable("id") Long id) {
//        Estoque estoque = service.buscarEstoquePorID(id);
//        EstoqueDTO dto =  EstoqueDTO.transformaEmDTO(estoque);
//        return ResponseEntity.ok().body(dto);
//    }
//
//    //TODO Testar
////    @GetMapping("/estoque")
////    public ResponseEntity<EstoqueDTO> buscarEstoquePorProduto(@PathParam("produto") ProdutoDTO produtoDTO){
////        Estoque estoque = service.buscarEstoquePorProduto(produtoDTO.trasnsformaParaProduto()) ;
////        EstoqueDTO dto = EstoqueDTO.transformaEmDTO(estoque);
////        return ResponseEntity.ok().body(dto);
////    }
//
//    @DeleteMapping("/estoque/{id}")
//    public void excluirEstoque(@PathVariable("id") Long id) {
//        service.excluirEstoquePorId(id);
//    }
//
//
//    @PutMapping("/estoque")
//    public ResponseEntity<EstoqueDTO> atulizarProduto(@RequestBody EstoqueDTO produtoDTO) {
//        Estoque estoque = service.atualizar(produtoDTO.trasnsformaParaEstoque());
//        EstoqueDTO dto = EstoqueDTO.transformaEmDTO(estoque);
//        return ResponseEntity.ok().body(dto);
//    }

    @PostMapping("/estoque")
    public ResponseEntity<Estoque> salvar(@RequestBody Estoque estoque) {

//        System.out.println("ID:::"+estoqueDTO.getId());
//        System.out.println("PR:::"+estoqueDTO.getProduto());
//        System.out.println("QT:::"+estoqueDTO.getQtdestoque());
//        Estoque e = estoqueDTO.trasnsformaParaEstoque();
//        System.out.printf("SOU O ESTOQUE"+e);
        return ResponseEntity.ok().body(service.salvar(estoque));
    }


    @GetMapping("/estoque")
    public ResponseEntity<List<Estoque>> listar() {
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/estoque/{id}")
    public ResponseEntity<Estoque> buscarEstoquePorID(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.buscarEstoquePorID(id));
    }

    //TODO Testar
//    @GetMapping("/estoque")
//    public ResponseEntity<EstoqueDTO> buscarEstoquePorProduto(@PathParam("produto") ProdutoDTO produtoDTO){
//        Estoque estoque = service.buscarEstoquePorProduto(produtoDTO.trasnsformaParaProduto()) ;
//        EstoqueDTO dto = EstoqueDTO.transformaEmDTO(estoque);
//        return ResponseEntity.ok().body(dto);
//    }

    @DeleteMapping("/estoque/{id}")
    public void excluirEstoque(@PathVariable("id") Long id) {
        service.excluirEstoquePorId(id);
    }


    @PutMapping("/estoque")
    public ResponseEntity<Estoque> atulizarProduto(@RequestBody Estoque produto) {
        return ResponseEntity.ok().body(service.atualizar(produto));
    }
}
