package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.ClienteResponseBO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PerfilController {



    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteResponseBO clienteResponseBO;

    @GetMapping("/perfilusuario/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Cliente> opt_pedido = clienteRepository.findById(id);
        Cliente cliente = opt_pedido.orElseThrow(() -> new ResourceNotFoundException("Perfil uauário não encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(clienteResponseBO.parseToDTO(cliente));

    }

}
