package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.dto.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {


    @Autowired
    private ProdutoService service;



    @PostMapping("/produto")
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = service.salvar(produtoDTO.trasnsformaParaProduto());
        return ResponseEntity.ok().body(ProdutoDTO.transformaEmDTO(produto));
    }


    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoDTO>> listar() {
        List<Produto> produtos = service.listar();
        List<ProdutoDTO> listaDTO = new ArrayList<>();

        for (Produto p :  produtos){
            ProdutoDTO dto = ProdutoDTO.transformaEmDTO(p);
            listaDTO.add(dto);
        }
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorID(@PathVariable("id") Long id) {
        Produto produto = service.buscarProdutoPorID(id);
        ProdutoDTO dto =  ProdutoDTO.transformaEmDTO(produto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/produto/{id}")
    public void excluirProduto(@PathVariable("id") Long id) {
        service.excluirProdutoPorId(id);
    }


    @PutMapping("/produto")
    public ResponseEntity<ProdutoDTO> atulizarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = service.atualizar(produtoDTO.trasnsformaParaProduto());
        ProdutoDTO dto = ProdutoDTO.transformaEmDTO(produto);
        return ResponseEntity.ok().body(dto);
    }

//    @PostMapping("/produto")
//    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
//        Produto produtoEntity = service.salvar(produto);
//
//
//        return ResponseEntity.ok().body(produtoEntity);
//    }
//
//    @GetMapping("/produto")
//    public ResponseEntity<List<Produto>> listar() {
//        return ResponseEntity.ok().body(service.listar());
//    }
//
//    @GetMapping("/produto/{id}")
//    public ResponseEntity<Produto> buscarProdutoPorID(@PathVariable("id") Long id) {
//        return ResponseEntity.ok().body(service.buscarProdutoPorID(id));
//    }
//
//    @DeleteMapping("/produto/{id}")
//    public void excluirProduto(@PathVariable("id") Long id) {
//        service.excluirProdutoPorId(id);
//    }
//
//    @PutMapping("/produto")
//    public ResponseEntity<Produto> atulizarProduto(@RequestBody Produto produto) {
//        return ResponseEntity.ok().body(service.atualizar(produto));
//    }

}
