package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.AuthorizationException;
import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.ClienteResponseBO;
import br.com.milvusartis.ecommerce.model.dto.PedidoDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import br.com.milvusartis.ecommerce.security.UserSS;
import br.com.milvusartis.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PerfilController {



    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteResponseBO clienteResponseBO;

    @Autowired
    UsuarioRepository usuarioRepository;



    @GetMapping("/perfilusuario")
    public ResponseEntity<?> buscaClientePorIDUsuario() {

        UserSS user = UsuarioService.authenticated();

        if(user == null){
            throw new AuthorizationException("Acesso negado");
        }

        Optional<Usuario> opt_cliente = usuarioRepository.findById(user.getId());
        Usuario usuario = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));


        Optional<Cliente> opt_pedido = clienteRepository.findById(usuario.getIdUsuario());
        Cliente cliente = opt_pedido.orElseThrow(() -> new ResourceNotFoundException("Perfil uauário não encontrado"));
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponseBO.parseToDTO(cliente));
    }



}
