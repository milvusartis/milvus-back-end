//package br.com.milvusartis.ecommerce.controller;
//
//import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
//import br.com.milvusartis.ecommerce.model.bo.ClienteBO;
//import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;;
//import br.com.milvusartis.ecommerce.model.entity.Cliente;
//import br.com.milvusartis.ecommerce.repository.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class ClienteController {
//
//    @Autowired
//    ClienteRepository clienteRepository;
//
//    @Autowired
//    ClienteBO clienteBO;
//
//    @PostMapping("/clientes")
//    public ResponseEntity<?> cadastrar(@RequestBody ClienteDTO clienteDTO) {
//
//        if (clienteDTO == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não pode estar vazio");
//        }
//
//        Cliente clienteEntity = clienteRepository.save(clienteBO.parseToPOJO(clienteDTO));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(clienteBO.parseToDTO(clienteEntity));
//
//    }
//
//    @GetMapping("/clientes")
//    public ResponseEntity<?> listar() {
//
//        List<Cliente> listaCliente = clienteRepository.findAll();
//        List<ClienteDTO> listaDeClienteResposta = new ArrayList<>();
//
//        listaCliente.forEach((cliente) -> {
//            listaDeClienteResposta.add(clienteBO.parseToDTO(cliente));
//        });
//
//        return ResponseEntity.status(HttpStatus.OK).body(listaDeClienteResposta);
//
//    }
//
//    @GetMapping("/clientes/{id}")
//    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {
//
//        Optional<Cliente> opt_cliente = clienteRepository.findById(id);
//        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrad0"));
//
//        return ResponseEntity.status(HttpStatus.OK).body(clienteBO.parseToDTO(cliente));
//
//    }
//
//    @DeleteMapping("/clientes/{id}")
//    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
//
//        return clienteRepository.findById(id)
//                .map(cliente -> {
//                    clienteRepository.delete(cliente);
//                    return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído");
//
//                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//
//    }
//
//}