package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CheckoutService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public Long UsuarioCliente(Long idUsuario) {
        Optional<Usuario> opt_usuario = usuarioRepository.findById(idUsuario);
        Usuario usuario = opt_usuario.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Cliente cliente = clienteRepository.findByUsuario(usuario);

        Long idCliente = cliente.getIdCliente();

        return idCliente;

    }

}
