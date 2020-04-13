package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    private Random rand = new Random();


    public void sendNewPassword(String email){

        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario==null){
            throw  new ResourceNotFoundException("Email não encontrado");
        }
        String newPass = newPassword();
        usuario.setSenha(pe.encode(newPass));
        usuarioRepository.save(usuario);
        emailService.sendNewPasswordEmail(usuario, newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for(int i=0; i<10; i++){
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    //https://unicode-table.com/pt/#control-character
    private char randomChar() {
        int opt = rand.nextInt(3);
        if(opt==0){//gera um digito
            return (char) (rand.nextInt(10)+48);
        }else if(opt ==1){//gera letra maiúscula
            return (char) (rand.nextInt(26)+65);
        }else{//gera letra minúscula
            return (char) (rand.nextInt(26)+97);
        }
    }


}
