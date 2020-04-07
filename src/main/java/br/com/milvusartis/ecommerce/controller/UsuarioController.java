package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.UsuarioBO;
import br.com.milvusartis.ecommerce.model.bo.UsuarioResponseBO;
import br.com.milvusartis.ecommerce.model.dto.UsuarioDTO;
import br.com.milvusartis.ecommerce.model.dto.UsuarioResponseDTO;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioBO usuarioBO;

    @Autowired
    UsuarioResponseBO usuarioResponseBO;

    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {

        if (usuarioDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não pode estar vazio");
        }

        Usuario usuarioEntity = usuarioRepository.save(usuarioBO.parseToPOJO(usuarioDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponseBO.parseToDTO(usuarioEntity));

    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> listar() {

        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> listaDeUsuariosResposta = new ArrayList<>();

        usuarios.forEach((usuario) -> {
            listaDeUsuariosResposta.add(usuarioResponseBO.parseToDTO(usuario));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDeUsuariosResposta);

    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Usuario> opt_usuario = usuarioRepository.findById(id);
        Usuario usuario = opt_usuario.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponseBO.parseToDTO(usuario));

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
