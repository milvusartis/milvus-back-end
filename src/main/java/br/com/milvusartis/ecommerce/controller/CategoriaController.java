package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.Categoria;
import br.com.milvusartis.ecommerce.model.DTO.CategoriaDTO;
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
    public ResponseEntity salvar(@RequestBody CategoriaDTO categoriaDTO) {
        return service.salvar(categoriaDTO);
    }

      //Parametro opicional, se não passar nada ele listrá todas as categorias
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


    @PutMapping("/categoria")
    public ResponseEntity<Categoria> alterar(@RequestBody CategoriaDTO categoriaDTO) {
        return service.alterar(categoriaDTO);
    }

//    @PatchMapping("/categoria")
//    public ResponseEntity alterarCamposEspecificos(@RequestBody CategoriaDTO categoriaDTO) {
//       return service.alterarCamposEspecificos(categoriaDTO);
//    }



}
