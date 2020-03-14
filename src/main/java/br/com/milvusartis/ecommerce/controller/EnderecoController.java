package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.EnderecoService;
import br.com.milvusartis.ecommerce.model.DTO.EnderecoDTO;
import br.com.milvusartis.ecommerce.model.Endereco;
import br.com.milvusartis.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/endereco")
    public ResponseEntity save(@RequestBody EnderecoDTO enderecoDTO){
        return ResponseEntity.ok().body(enderecoService.save(enderecoDTO));
    }

    @GetMapping("/endereco/")
    public List<Endereco> find(){
        return enderecoRepository.findAll();
    }

    @GetMapping("/endereco/{idEndereco}")
    public Endereco findById(@PathVariable("idEndereco")Long idEndereco){
        return enderecoRepository.findById(idEndereco).get();
    }

    @DeleteMapping("/endereco/{idEndereco}")
    public void deleteById(@PathVariable("idEndereco") Long idEndereco) {
        enderecoService.deleteById(idEndereco);
    }
}
