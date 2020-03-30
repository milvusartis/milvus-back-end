package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.ClienteBO;
import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    ClienteRepository repository;


    @Autowired
    private ClienteBO clienteBO;


    @GetMapping("/clientes")
    public ResponseEntity<?> listar() {
        List<Cliente> clientes = repository.findAll();
        List<ClienteDTO> listaDeClientesResposta = new ArrayList<>();

        clientes.forEach((cliente) -> {
            listaDeClientesResposta.add(clienteBO.parseToDTO(cliente));
        });
        return ResponseEntity.status(HttpStatus.OK).body(listaDeClientesResposta);
    }



    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não pode estar vazio");
        }

        Cliente clienteEntity = repository.save(clienteBO.parseToPOJO(clienteDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteBO.parseToDTO(clienteEntity));

    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {
        Optional<Cliente> opt_cliente = repository.findById(id);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return ResponseEntity.status(HttpStatus.OK).body(clienteBO.parseToDTO(cliente));
    }


    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}