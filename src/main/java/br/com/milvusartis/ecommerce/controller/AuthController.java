package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.bo.UsuarioBO;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.milvusartis.ecommerce.model.tipos.Regra.ROLE_ADMIN;

@RestController
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioBO usuarioBO;

    @GetMapping("/auth/token")
    public ResponseEntity<?> perfil(Authentication authentication) {
        Usuario user = usuarioRepository.findByEmail(authentication.getName());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioBO.parseToDTO(user));
    }

    @GetMapping("/auth/admin/token")
    public ResponseEntity<?> perfilAdmin(Authentication authentication) {
        Usuario user = usuarioRepository.findByEmail(authentication.getName());

        if(user.getRegraDeAcesso() == ROLE_ADMIN)
            return ResponseEntity.status(HttpStatus.OK).body(usuarioBO.parseToDTO(user));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário sem permissão");
    }


}
