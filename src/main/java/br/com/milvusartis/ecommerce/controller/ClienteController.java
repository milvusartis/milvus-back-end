package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.ClienteService;
import br.com.milvusartis.ecommerce.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cliente")
    public ResponseEntity save(@RequestBody Cliente cl) {
        return ResponseEntity.ok().body(clienteService.cadastrarCliente(cl));
    }

    @GetMapping("/cliente")
    public ResponseEntity buscarLista(Long id) {
        return ResponseEntity.ok().body(clienteService.buscarCliente(id));
    }

    @GetMapping("/clientes")
    public ResponseEntity buscarTodos() {
        return ResponseEntity.ok().body(clienteService.buscarTodosOsClientes());
    }

    @PutMapping("/cliente")
    public ResponseEntity alterar(@RequestBody Cliente cl) {
        return ResponseEntity.ok().body(clienteService.alterarCliente(cl));
    }

    @DeleteMapping("/cliente")
    public void deletar(Long id) {
        clienteService.deletarCliente(id);
    }

}