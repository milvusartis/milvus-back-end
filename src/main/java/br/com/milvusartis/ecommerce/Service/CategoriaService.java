package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.Categoria;
import br.com.milvusartis.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CategoriaService")
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public ResponseEntity salvar(Categoria categoria) {
        return ResponseEntity.ok().body(repository.save(categoria));
    }

    public ResponseEntity buscaPorId(Long idCategoria) {
        return ResponseEntity.ok().body(repository.findById(idCategoria).get());
    }

    public ResponseEntity<List<Categoria>> buscarCategoria(Long id, String descricao) {

        List<Categoria> lista = new ArrayList<>();
        System.out.println(id);
        System.out.println(descricao);

        if (id == null && descricao == null)
            lista = repository.findAll();
        else if (id != null)
            lista.add(repository.findById(id).get());
        else if (descricao != null)
            lista = repository.findByDescricao(descricao);

        //Se passa um id que existe mas uma descricao que nao existe,ele sempre está considerando o primeiro parametro
        if (lista != null && lista.size() > 0) {
            return ResponseEntity.ok().body(lista);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    public ResponseEntity alterar(Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getId());
        categoriaEntity.setDescricao(categoria.getDescricao());
        return ResponseEntity.ok().body(repository.save(categoria));
    }


    public ResponseEntity alteraCamposEspecificos(Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getId());
        categoriaEntity.setDescricao(categoria.getDescricao());
        return ResponseEntity.ok().body(repository.save(categoriaEntity));
    }
}
