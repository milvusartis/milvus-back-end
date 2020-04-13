package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.dto.EmailDTO;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import br.com.milvusartis.ecommerce.security.JWTUtil;
import br.com.milvusartis.ecommerce.security.UserSS;
import br.com.milvusartis.ecommerce.service.AuthService;
import br.com.milvusartis.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

//    @GetMapping("/auth/token")
//    public ResponseEntity<?> perfil(Authentication authentication) {
//        Usuario user = usuarioRepository.findByEmail(authentication.getName());
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//    }

//    @GetMapping("/auth/admin/token")
//    public ResponseEntity<?> perfilAdmin(Authentication authentication) {
//        Usuario user = usuarioRepository.findByEmail(authentication.getName());
//
//        if(user.getPerfis() == ADMIN)
//            return ResponseEntity.status(HttpStatus.OK).body(usuarioBO.parseToDTO(user));
//        else
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário sem permissão");
//    }


    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UsuarioService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO emailDTO) {
        service.sendNewPassword(emailDTO.getEmail());
        return ResponseEntity.noContent().build();
    }

}
