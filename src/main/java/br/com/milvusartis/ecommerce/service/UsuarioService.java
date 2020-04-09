package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.model.tipos.Regra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    BCryptPasswordEncoder encoder;

    public Usuario definirAcessoSeguranca(Usuario usuario){
        usuario.setRegraDeAcesso(Regra.ROLE_USER);
        String senha = usuario.getSenha();
        usuario.setSenha(encoder.encode(senha));
        return usuario;
    }
}
