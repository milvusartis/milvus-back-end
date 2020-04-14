package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.EnderecoBO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Endereco;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EnderecoController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoBO enderecoBO;

    @PutMapping("/enderecos/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody Endereco edicao) {

        Optional<Cliente> opt_cliente = clienteRepository.findById(id);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Endereco endereco = cliente.getEndereco();

        if(edicao.getRua() != null)
            endereco.setRua(edicao.getRua());

        if(edicao.getNumero() != null)
            endereco.setNumero(edicao.getNumero());

        if(edicao.getComplemento() != null)
            endereco.setComplemento(edicao.getComplemento());

        if(edicao.getBairro() != null)
            endereco.setBairro(edicao.getBairro());

        if(edicao.getCidade() != null)
            endereco.setCidade(edicao.getCidade());

        if(edicao.getUf() != null)
            endereco.setUf(edicao.getUf());

        if(edicao.getCep() != null)
            endereco.setCep(edicao.getCep());

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoBO.parseToDTO(endereco));

    }

}
