package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.bo.CategoriaBO;
import br.com.milvusartis.ecommerce.model.bo.ProdutoBO;
import br.com.milvusartis.ecommerce.model.dto.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.entity.Estoque;
import br.com.milvusartis.ecommerce.model.entity.Produto;
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

    @Autowired
    private ProdutoBO produtoBO;

    @Autowired
    private CategoriaBO categoriaBO;




    @PostMapping("/produto")
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = service.salvar(produtoBO.parseToPOJO(produtoDTO));
        return ResponseEntity.ok().body(produtoBO.parseToDTO(produto));
    }


    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoDTO>> listar() {
        List<Produto> produtos = service.listar();
        List<ProdutoDTO> listaDTO = new ArrayList<>();

        for (Produto p :  produtos){
            ProdutoDTO dto = produtoBO.parseToDTO(p);
            listaDTO.add(dto);
        }
        return ResponseEntity.ok().body(listaDTO);
    }

       @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorID(@PathVariable("id") Long id) {
        Produto produto = service.buscarProdutoPorID(id);
        ProdutoDTO dto =  produtoBO.parseToDTO(produto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/produto/{id}")
    public void excluirProduto(@PathVariable("id") Long id) {
        service.excluirProdutoPorId(id);
    }


    @PutMapping("/produto")
    public ResponseEntity<ProdutoDTO> atulizarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = service.atualizar(produtoBO.parseToPOJO(produtoDTO));
        ProdutoDTO dto = produtoBO.parseToDTO(produto);
        return ResponseEntity.ok().body(dto);
    }

}
