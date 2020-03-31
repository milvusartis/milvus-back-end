package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
        import br.com.milvusartis.ecommerce.model.bo.CategoriaBO;
        import br.com.milvusartis.ecommerce.model.dto.CategoriaDTO;
        import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;
        import br.com.milvusartis.ecommerce.model.entity.Categoria;
        import br.com.milvusartis.ecommerce.model.entity.Cliente;
        import br.com.milvusartis.ecommerce.repository.CategoriaRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CategoriaBO categoriaBO;

    @PostMapping("/categorias")
    public ResponseEntity<?> cadastrar(@RequestBody CategoriaDTO categoriaDTO) {

        if (categoriaDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não pode estar vazia");
        }

        Categoria categoriaEntity = categoriaRepository.save(categoriaBO.parseToPOJO(categoriaDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaBO.parseToDTO(categoriaEntity));

    }

    @GetMapping("/categorias")
    public ResponseEntity<?> listar() {

        List<Categoria> listaCategorias = categoriaRepository.findAll();
        List<CategoriaDTO> listaDeCategoriasResposta = new ArrayList<>();

        listaCategorias.forEach((categoria) -> {
            listaDeCategoriasResposta.add(categoriaBO.parseToDTO(categoria));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDeCategoriasResposta);

    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Categoria> opt_categoria = categoriaRepository.findById(id);
        Categoria categoria = opt_categoria.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        return ResponseEntity.status(HttpStatus.OK).body(categoriaBO.parseToDTO(categoria));

    }

//    @GetMapping("/categorias/{nm}")
//    public ResponseEntity<?> mostrar(@PathVariable("nm") String nm) {
//
//        Optional<Categoria> opt_categoria = categoriaRepository.findByNome(nm);
//        Categoria categoria = opt_categoria.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
//
//        return ResponseEntity.status(HttpStatus.OK).body(categoriaBO.parseToDTO(categoria));
//
//    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {

        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoriaRepository.delete(categoria);
                    return ResponseEntity.status(HttpStatus.OK).body("Categoria excluída");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}
