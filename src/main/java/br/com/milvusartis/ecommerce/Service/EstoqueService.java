package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.Estoque;
import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EstoqueService")
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public Estoque salvar(Estoque estoque) {
        return repository.save(estoque);
    }

    public List<Estoque> listar() {
        return repository.findAll();
    }

    public Estoque buscarEstoquePorID(Long id) {
        return repository.findById(id).get();
    }

    public Estoque buscarEstoquePorProduto(Produto produto){
        return repository.findByProduto(produto);
    }

    public Estoque atualizar(Estoque estoque) {
        Estoque estoqueEntity = repository.getOne(estoque.getIdEstoque());
        estoqueEntity.setProduto(estoque.getProduto());
        estoqueEntity.setQuantidadeEstoque(estoque.getQuantidadeEstoque());
        estoqueEntity.setQuantidadeReservada(estoque.getQuantidadeReservada());
        return repository.save(estoqueEntity);
    }

    public void excluirEstoquePorId(Long id) {
        repository.deleteById(id);
    }
}
