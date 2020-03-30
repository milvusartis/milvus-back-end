package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;


    public List<Cliente> buscarTodosOsClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes;
    }


    public Cliente cadastrarCliente(Cliente cliente) {
        Cliente clienteEntity = repository.save(cliente);
        return clienteEntity;

    }

    public Cliente buscarCliente(@PathParam("id_cliente") Long idCliente) {
        Optional<Cliente> opt_cliente = repository.findById(idCliente);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return cliente;
    }
}
