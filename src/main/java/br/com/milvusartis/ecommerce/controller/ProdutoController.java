package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/produto")
    public Produto save(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }


    @GetMapping("/produto")
    public List<Produto> find(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto buscarProdutoPorID(@PathVariable("id") Long id){
        return produtoRepository.findById(id).get();
    }
}
