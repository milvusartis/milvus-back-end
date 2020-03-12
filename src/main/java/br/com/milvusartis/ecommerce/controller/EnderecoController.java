package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.Endereco;
import br.com.milvusartis.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping("/create-endereco")
    public Endereco save(@RequestBody Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    @GetMapping("/find-endereco/list")
    public List<Endereco> find(){
        return enderecoRepository.findAll();
    }
}
