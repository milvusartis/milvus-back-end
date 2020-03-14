package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.DTO.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {


    @Autowired
    private ProdutoService service;


    @PostMapping("/produto")
    public ResponseEntity<Produto> salvar(@RequestBody ProdutoDTO produtoDTO) {
        return service.salvar(produtoDTO);
    }


    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoDTO>> listar() {
        return service.listar();
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> buscarProdutoPorID(@PathVariable("id") Long id) {
        return service.buscarProdutoPorID(id);
    }

    @DeleteMapping("/produto/{id}")
    public void excluirProduto(@PathVariable("id") Long id) {
        service.excluirProdutoPorId(id);
    }


    @PutMapping("/produto")
    public ResponseEntity<Produto> atulizarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return service.atualizar(produtoDTO);
    }

}
