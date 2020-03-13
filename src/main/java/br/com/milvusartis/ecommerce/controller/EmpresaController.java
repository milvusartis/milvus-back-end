package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.EmpresaService;
import br.com.milvusartis.ecommerce.model.DTO.EmpresaDTO;
import br.com.milvusartis.ecommerce.model.Empresa;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/empresa")
    public ResponseEntity save(@RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.ok().body(empresaService.save(empresaDTO));
    }
//    @GetMapping("/find-empresa/list")
//    public List<Empresa> find(){
//        return empresaRepository.findAll();
//    }
//    public EmpresaController(EmpresaRepository empresaRepository){
//        this.empresaRepository = empresaRepository;
//    }
//
//


}
