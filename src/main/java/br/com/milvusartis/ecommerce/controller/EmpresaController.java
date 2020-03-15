package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.EmpresaService;
import br.com.milvusartis.ecommerce.model.DTO.EmpresaDTO;
import br.com.milvusartis.ecommerce.model.Empresa;
import br.com.milvusartis.ecommerce.model.Endereco;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping("/empresa")
    public ResponseEntity save(@RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.ok().body(empresaService.save(empresaDTO));
    }

    @GetMapping("/empresa/")
    public List<Empresa> find(){
        return empresaRepository.findAll();
    }

    @GetMapping("/empresa/{idempresa}")
    public Empresa findById(@PathVariable("idempresa")Long idempresa){
        return empresaRepository.findById(idempresa).get();
    }

    @DeleteMapping("/empresa/{idempresa}")
    public void deleteById(@PathVariable("idempresa") Long idempresa) {
        empresaService.deleteById(idempresa);
    }

    @PutMapping("/empresa")
    public ResponseEntity alterar(@RequestBody Empresa empresa){
        return ResponseEntity.ok().body(empresaService.alterar(empresa));
    }
}
