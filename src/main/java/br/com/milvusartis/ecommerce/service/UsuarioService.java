package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    BCryptPasswordEncoder encoder;

    public Usuario definirAcessoSeguranca(Usuario usuario){
        String senha = usuario.getSenha();
        usuario.setSenha(encoder.encode(senha));
        return usuario;
    }

    public static UserSS authenticated(){
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }

}
