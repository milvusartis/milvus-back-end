package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.ClienteBO;
import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;
import br.com.milvusartis.ecommerce.service.ClienteService;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    private ClienteBO clienteBO;


    @GetMapping("/clientes")
    public ResponseEntity listar() {
        List<Cliente> clientes = clienteService.buscarTodosOsClientes();

        List<ClienteDTO> listaDeClientes = new ArrayList<>();

        clientes.forEach((cliente) -> {
            listaDeClientes.add(clienteBO.parseToDTO(cliente));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDeClientes);
    }


    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não pode estar vazio");
        }

        Cliente clienteAtualizado = clienteService.cadastrarCliente(clienteBO.parseToPOJO(clienteDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteBO.parseToDTO(clienteAtualizado));

    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }


}