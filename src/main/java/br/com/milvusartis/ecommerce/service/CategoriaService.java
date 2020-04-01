package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Categoria;
import br.com.milvusartis.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CategoriaService")
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria buscaPorId(Long idCategoria) {
        return repository.findById(idCategoria).get();
    }

    public List<Categoria> buscarCategoria(Long id, String nome) {

        List<Categoria> lista = new ArrayList<>();

        if (id == null && nome == null)
            lista = repository.findAll();
        else if (id != null)
            lista.add(repository.findById(id).get());
        else if (nome != null)
            lista = repository.findByNome(nome);

        return lista;
    }


    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    public Categoria alterar(Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getIdCategoria());
        categoriaEntity.setNome(categoria.getNome());
        return repository.save(categoriaEntity);
    }

    public Categoria alterarCamposEspecificos(Categoria categoria) {
        return this.alterar(categoria);
    }





}
