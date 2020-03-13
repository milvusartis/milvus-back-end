package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.EnderecoService;
import br.com.milvusartis.ecommerce.model.DTO.EnderecoDTO;
import br.com.milvusartis.ecommerce.model.Endereco;
import br.com.milvusartis.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/endereco")
    public ResponseEntity save(@RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.ok().body(enderecoService.save(enderecoDTO));
    }

//    @GetMapping("/find-endereco/list")
//    public List<Endereco> find(){
//        return enderecoRepository.findAll();
//    }
}
