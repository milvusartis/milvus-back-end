package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Categoria;
import br.com.milvusartis.ecommerce.model.entity.Estoque;
import br.com.milvusartis.ecommerce.model.entity.Produto;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProdutoService")
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;


    public Produto salvar(Produto produto) {
        Produto produtoEntity = produto;
        Categoria categoria = categoriaService.buscaPorId(produto.getCategoria().getId());
        produtoEntity.setCategoria(categoria);
        return produtoRepository.save(produtoEntity);
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
        produtoEntity.setVlUnitario(produto.getVlUnitario());
        produtoEntity.setCategoria(produto.getCategoria());
        produtoEntity.setEstoque(produto.getEstoque());
        return produtoRepository.save(produtoEntity);
    }

    public void excluirProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }
}
