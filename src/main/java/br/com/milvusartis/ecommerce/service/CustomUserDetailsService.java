package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = usuarioRepository.findByEmail(email);
        System.out.println(user.getNome());

        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(user.getRegraDeAcesso().name());
        System.out.println(authorityList.toString());
        return new User(
                user.getEmail(),
                user.getSenha(),
                authorityList
        );
    }
}