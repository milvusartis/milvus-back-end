package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.Categoria;
import br.com.milvusartis.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @PostMapping("/categoria")
    public ResponseEntity salvar(@RequestBody Categoria categoria) {
        return service.salvar(categoria);
    }

      //Parametro opicional
    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> buscarCategoria(@PathParam("id") Long id,
                                                           @PathParam("descricao") String descricao) {
        return service.buscarCategoria(id, descricao);
    }

    @DeleteMapping("/categoria/{id}")
    public void excluirPorId(@PathVariable("id") Long id) {
        service.excluirPorId(id);
    }

//

    //Put alterar todos os campos, Patch alterar alguns apenas

        /*
    @PutMapping("/categoria")
    public ResponseEntity<Categoria >alterar(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getCodigo());
        categoriaEntity.setDescricao(categoria.getDescricao());
        Categoria categoriaAtualizada = repository.save(categoriaEntity);
        return ResponseEntity.ok().body(categoriaAtualizada);
    }
      */

//    @PutMapping("/categoria")
//    public ResponseEntity alterar(@RequestBody Categoria categoria) {
//        Categoria categoriaEntity = service.alterar(categoria);
//        categoriaEntity.setDescricao(categoria.getDescricao());
//        return service.alterar(categoriaEntity);
//    }


//    @PatchMapping("/categoria")
//    public ResponseEntity alteraCamposEspecificos(@RequestBody Categoria categoria) {
//        Categoria categoriaEntity = service.getOne(categoria.getCodigo());
//        categoriaEntity.setDescricao(categoria.getDescricao());
//        return service.save(categoriaEntity);
//    }



}
