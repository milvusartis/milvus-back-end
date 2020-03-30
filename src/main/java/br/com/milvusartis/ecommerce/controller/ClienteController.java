package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.service.ClienteService;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping("/clientes")
    public ResponseEntity listar() {
        List<Cliente> clientes = clienteService.buscarTodosOsClientes();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }


    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não pode estar vazio");
        }

        Cliente clienteAtualizado = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteAtualizado);

    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }





//    @GetMapping("/clientes")
//    public ResponseEntity<?> buscarLista(Long id) {
//        return ResponseEntity.ok().body(clienteService.buscarCliente(id));
//    }
//

//
//
//
//
//
//    @PutMapping("/clientes")
//    public ResponseEntity<?> alterar(@RequestBody Cliente cl) {
//        return ResponseEntity.ok().body(clienteService.alterarCliente(cl));
//    }
//
//    @DeleteMapping("/clientes")
//    public void deletar(Long id) {
//        clienteService.deletarCliente(id);
//    }

}