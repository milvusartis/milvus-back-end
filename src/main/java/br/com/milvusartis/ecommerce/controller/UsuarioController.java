package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;


    @PreAuthorize("has")
    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não pode estar vazio");
        }

        Usuario usuarioEntity = usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioEntity);

    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> listar() {

        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Usuario> listaDeUsuariosResposta = new ArrayList<>();

        usuarios.forEach((usuario) -> {
            listaDeUsuariosResposta.add(usuario);
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDeUsuariosResposta);

    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Usuario> opt_usuario = usuarioRepository.findById(id);
        Usuario usuario = opt_usuario.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(usuario);

    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {

        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.status(HttpStatus.OK).body("Usuario excluido");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}
