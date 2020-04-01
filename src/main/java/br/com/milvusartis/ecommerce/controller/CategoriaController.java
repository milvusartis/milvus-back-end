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
    CategoriaRepository repository;


    @Autowired
    CategoriaBO categoriaBO;


    @GetMapping("/categorias")
    public ResponseEntity<?> listar() {
        List<Categoria> ListaCategorias = repository.findAll();
        List<CategoriaDTO> listaDeCategoriasResposta = new ArrayList<>();

        ListaCategorias.forEach((categoria) -> {
            listaDeCategoriasResposta.add(categoriaBO.parseToDTO(categoria));
        });
        return ResponseEntity.status(HttpStatus.OK).body(listaDeCategoriasResposta);
    }



    @PostMapping("/categorias")
    public ResponseEntity<?> cadastrar(@RequestBody CategoriaDTO categoriaDTO) {
        if (categoriaDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não pode estar vazia");
        }

        Categoria categoriaEntity = repository.save(categoriaBO.parseToPOJO(categoriaDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaBO.parseToDTO(categoriaEntity));

    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {
        Optional<Categoria> opt_categoria = repository.findById(id);
        Categoria categoria = opt_categoria.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
        return ResponseEntity.status(HttpStatus.OK).body(categoriaBO.parseToDTO(categoria));
    }


    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(categoria -> {
                    repository.delete(categoria);
                    return ResponseEntity.status(HttpStatus.OK).body("Categoria excluida");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
