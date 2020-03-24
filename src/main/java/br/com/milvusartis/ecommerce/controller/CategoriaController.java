package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.bo.CategoriaBO;
import br.com.milvusartis.ecommerce.model.entity.Categoria;
import br.com.milvusartis.ecommerce.model.dto.CategoriaDTO;
import br.com.milvusartis.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Autowired
    private CategoriaBO categoriaBO;

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaDTO> salvar(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = service.salvar(categoriaBO.parseToPOJO(categoriaDTO));
        CategoriaDTO dto = categoriaBO.parseToDTO(categoria);
        return ResponseEntity.ok().body(dto);
    }

    //Parametro opicional, se não passar nada ele listrá todas as categorias
    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaDTO>> buscarCategoria(@PathParam("codigo") Long id,
                                                              @PathParam("nome") String nome) {
        List<Categoria> listaDeCategorias = service.buscarCategoria(id, nome);
        //Se passa um id que existe mas um nome que nao existe, ele sempre está considerando o primeiro parametro
        if (listaDeCategorias != null && listaDeCategorias.size() > 0) {
            List<CategoriaDTO> listaDTO = new ArrayList<>();
            for (Categoria c : listaDeCategorias) {
                listaDTO.add(categoriaBO.parseToDTO(c));
            }
            return ResponseEntity.ok().body(listaDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/categoria/{id}")
    public void excluirPorId(@PathVariable("id") Long id) {
        service.excluirPorId(id);
    }

//

    //Put alterar todos os campos, Patch alterar alguns apenas


    @PutMapping("/categoria")
    public ResponseEntity<CategoriaDTO> alterar(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = service.alterar(categoriaBO.parseToPOJO(categoriaDTO));
        return ResponseEntity.ok().body(categoriaBO.parseToDTO(categoria));

    }

//    @PatchMapping("/categoria")
//    public ResponseEntity alterarCamposEspecificos(@RequestBody CategoriaDTO categoriaDTO) {
//       return service.alterarCamposEspecificos(categoriaDTO);
//    }

//    @PostMapping("/categoria")
//    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
//        return ResponseEntity.ok().body(service.salvar(categoria));
//    }
//
//    //Parametro opicional, se não passar nada ele listrá todas as categorias
//    @GetMapping("/categoria")
//    public ResponseEntity<List<Categoria>> buscarCategoria(@PathParam("codigo") Long id,
//                                                              @PathParam("nome") String nome) {
//        List<Categoria> listaDeCategorias = service.buscarCategoria(id, nome);
//        //Se passa um id que existe mas um nome que nao existe,ele sempre está considerando o primeiro parametro
//        if (listaDeCategorias != null && listaDeCategorias.size() > 0) {
//
//            return ResponseEntity.ok().body(listaDeCategorias);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//
//    }
//
//    @DeleteMapping("/categoria/{id}")
//    public void excluirPorId(@PathVariable("id") Long id) {
//        service.excluirPorId(id);
//    }
//
////
//
//    //Put alterar todos os campos, Patch alterar alguns apenas
//
//
//    @PutMapping("/categoria")
//    public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria) {
//        return ResponseEntity.ok().body(service.alterar(categoria));
//
//    }
}
