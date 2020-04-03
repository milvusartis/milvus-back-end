package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.dto.ClienteResponseDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
UsuarioRepository repository;

//    @GetMapping("/usuarios")
//    public ResponseEntity<?> listar(@PathParam("nome")String nome, @PathParam("email") String email ) {
//        List<Usuario> usuarios = repository.findByNomeOrEmail(nome, email);
//        return ResponseEntity.status(HttpStatus.OK).body(usuarios);

//    }

}
