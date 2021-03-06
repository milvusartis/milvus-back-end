package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.AuthorizationException;
import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.ClienteBO;
import br.com.milvusartis.ecommerce.model.bo.ClienteCadastroBO;
import br.com.milvusartis.ecommerce.model.bo.ClienteResponseBO;
import br.com.milvusartis.ecommerce.model.dto.ClienteCadastroDTO;
import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;
import br.com.milvusartis.ecommerce.model.dto.ClienteResponseDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.tipos.Perfil;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.security.UserSS;
import br.com.milvusartis.ecommerce.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteBO clienteBO;

    @Autowired
    ClienteCadastroBO clienteCadastroBO;

    @Autowired
    ClienteResponseBO clienteResponseBO;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteCadastroDTO clienteCadastroDTO) {

        if (clienteCadastroDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não pode estar vazio");
        }

        Cliente cliente = clienteCadastroBO.parseToPOJO(clienteCadastroDTO);

        usuarioService.definirAcessoSeguranca(cliente.getUsuario());

        Cliente clienteEntity = clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastroBO.parseToDTO(clienteEntity));

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/clientes")
    public ResponseEntity<?> listar() {

        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponseDTO> listaDeClientesResposta = new ArrayList<>();

        clientes.forEach((cliente) -> {
            listaDeClientesResposta.add(clienteResponseBO.parseToDTO(cliente));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDeClientesResposta);

    }


    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        UserSS user = UsuarioService.authenticated();

        if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())){
            throw new AuthorizationException("Acesso negado");
        }

        Optional<Cliente> opt_cliente = clienteRepository.findById(id);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(clienteBO.parseToDTO(cliente));

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody Cliente edicao) {

        Optional<Cliente> opt_cliente = clienteRepository.findById(id);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        if(edicao.getRg() != null)
            cliente.setRg(edicao.getRg());

        if(edicao.getTelefone() != null)
            cliente.setTelefone(edicao.getTelefone());

        if(edicao.getUsuario().getNome() != null)
            cliente.getUsuario().setNome(edicao.getUsuario().getNome());

        if(edicao.getUsuario().getEmail() != null)
            cliente.getUsuario().setEmail(edicao.getUsuario().getEmail());

        if(edicao.getUsuario().getSenha() != null)
            cliente.getUsuario().setSenha(edicao.getUsuario().getSenha());

        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteBO.parseToDTO(cliente));

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {

        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}