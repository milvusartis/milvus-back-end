package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.DTO.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.Estoque;
import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProdutoService")
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listar() {
         return produtoRepository.findAll();
    }


    public Produto buscarProdutoPorID(Long id) {
        return produtoRepository.findById(id).get();
    }

    public Produto atualizar(Produto produto) {
        Produto produtoEntity = produtoRepository.getOne(produto.getIdProduto());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setValorUnitario(produto.getValorUnitario());
        produtoEntity.setCategoria(produto.getCategoria());
        produtoEntity.setEstoque(produto.getEstoque());
        return produtoRepository.save(produtoEntity);
    }

    public void excluirProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }
}
