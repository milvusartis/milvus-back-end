package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    public List<Cliente> buscarTodosOsClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes;
    }




    public Cliente cadastrarCliente(Cliente cliente) {
        Cliente clienteEntity =  repository.save(cliente);
        return clienteEntity;

    }

    public ResponseEntity buscarCliente(@PathParam("id_cliente") Long idCliente) {

        List<Cliente> cliente = new ArrayList<>();

        if (idCliente != null)
            cliente.add(repository.findById(idCliente).get());

        if (cliente != null && cliente.size() > 0)
            return ResponseEntity.ok().body(cliente);
        else
            return ResponseEntity.badRequest().build();

    }



//    public ResponseEntity alterarCliente(@RequestBody Cliente cliente) {
//
//        Cliente clienteEntity = new Cliente();
//
//        if(cliente != null)
//            clienteEntity = repository.getOne(cliente.getId());
//
//            clienteEntity.setNome(cliente.getNome());
//            clienteEntity.setCpf(cliente.getCpf());
//            clienteEntity.setTelefone(cliente.getTelefone());
//            clienteEntity.setEmail(cliente.getEmail());
//            clienteEntity.setSenha(cliente.getSenha());
//            clienteEntity.setTelefone(cliente.getTelefone());
//
//        if(clienteEntity != null)
//            return ResponseEntity.ok().body(repository.save(clienteEntity));
//        else
//            return ResponseEntity.badRequest().build();
//    }
//
//    public void deletarCliente(@PathVariable("id_cliente") Long id) {
//        repository.deleteById(id);
//    }
}
