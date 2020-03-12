package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.Empresa;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    @PostMapping("/create-empresa")
    public Empresa save(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }

    @GetMapping("/find-empresa/list")
    public List<Empresa> find(){
        return empresaRepository.findAll();
    }
}
