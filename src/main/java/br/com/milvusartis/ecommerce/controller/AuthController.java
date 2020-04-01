package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/auth/token")
    public Usuario perfil(Authentication authentication) {
        System.out.println(authentication);
        Usuario user = usuarioRepository.findByEmail(authentication.getName());
        System.out.println(user.getNome()+"ESSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        return user;
    }
}
