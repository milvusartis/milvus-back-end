package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProdutoService")
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ResponseEntity<Produto> salvar(Produto produto) {
        return ResponseEntity.ok().body(produtoRepository.save(produto));
    }

    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok().body(produtoRepository.findAll());
    }


    public ResponseEntity<Produto> buscarProdutoPorID(Long id) {
        return ResponseEntity.ok().body(produtoRepository.findById(id).get());
    }

    public ResponseEntity<Produto> atualizar(Produto produto) {
        Produto produtoEntity = produtoRepository.getOne(produto.getIdProduto());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setValorUnitario(produto.getValorUnitario());



        produto.setCategoria(produto.getCategoria());
        return ResponseEntity.ok().body(produtoRepository.save(produtoEntity));
    }

    public void excluirProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }

//    @DeleteMapping("/produto")
//    public void excluirProduto(@RequestBody Produto produto) {
//        repository.delete(produto);
//    }

//

}
