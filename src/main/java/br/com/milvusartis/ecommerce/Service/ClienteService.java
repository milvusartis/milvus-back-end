package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.Cliente;
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
    ClienteRepository clienteRepository;

    public ResponseEntity cadastrarCliente(Cliente cliente) {

        Cliente clienteEntity = new Cliente();

        if(cliente != null)
            clienteEntity = clienteRepository.save(cliente);

        if(clienteEntity != null)
            return ResponseEntity.ok().body(clienteEntity);
        else
            return ResponseEntity.badRequest().build();

    }

    public ResponseEntity buscarCliente(@PathParam("id_cliente") Long idCliente) {

        List<Cliente> cliente = new ArrayList<>();

        if (idCliente != null)
            cliente.add(clienteRepository.findById(idCliente).get());

        if (cliente != null && cliente.size() > 0)
            return ResponseEntity.ok().body(cliente);
        else
            return ResponseEntity.badRequest().build();

    }

    public ResponseEntity buscarTodosOsClientes() {

        List<Cliente> cliente = clienteRepository.findAll();

        if (cliente != null && cliente.size() > 0)
            return ResponseEntity.ok().body(cliente);
        else
            return ResponseEntity.badRequest().build();
    }

    public ResponseEntity alterarCliente(@RequestBody Cliente cliente) {

        Cliente clienteEntity = new Cliente();

        if(cliente != null)
            clienteEntity = clienteRepository.getOne(cliente.getIdCliente());

            clienteEntity.setNmCliente(cliente.getNmCliente());
            clienteEntity.setDsCpf(cliente.getDsCpf());
            clienteEntity.setDsTelefone(cliente.getDsTelefone());
            clienteEntity.setDsEmail(cliente.getDsEmail());
            clienteEntity.setDsSenha(cliente.getDsSenha());
            clienteEntity.setDsTelefone(cliente.getDsTelefone());

        if(clienteEntity != null)
            return ResponseEntity.ok().body(clienteRepository.save(clienteEntity));
        else
            return ResponseEntity.badRequest().build();
    }

    public void deletarCliente(@PathVariable("id_cliente") Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}