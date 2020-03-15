package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.EnderecoService;
import br.com.milvusartis.ecommerce.model.DTO.EnderecoDTO;
import br.com.milvusartis.ecommerce.model.Endereco;
import br.com.milvusartis.ecommerce.model.NotaFiscal;
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

    @GetMapping("/endereco/{idendereco}")
    public Endereco findById(@PathVariable("idendereco")Long idendereco){
        return enderecoRepository.findById(idendereco).get(); }

    @DeleteMapping("/endereco/{idendereco}")
    public void deleteById(@PathVariable("idendereco") Long idendereco) {
        enderecoService.deleteById(idendereco);
    }

    @PutMapping("/endereco")
    public ResponseEntity alterar(@RequestBody Endereco endereco) {
        return ResponseEntity.ok().body(enderecoService.alterar(endereco));
    }
}
