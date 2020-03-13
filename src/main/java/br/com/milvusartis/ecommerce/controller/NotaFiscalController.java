package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.NotaFiscalService;
import br.com.milvusartis.ecommerce.model.DTO.NotaFiscalDTO;
import br.com.milvusartis.ecommerce.model.Empresa;
import br.com.milvusartis.ecommerce.model.NotaFiscal;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @PostMapping("/notaFiscal")
    public ResponseEntity save(@RequestBody NotaFiscalDTO notaFiscalDTO){
        return ResponseEntity.ok().body(notaFiscalService.save(notaFiscalDTO));
    }

    @GetMapping("/notaFiscal/")
    public List<NotaFiscal> find(){
        return notaFiscalRepository.findAll();
    }

    @GetMapping("/notaFiscal/{idNf}")
    public NotaFiscal findById(@PathVariable("idNf")Long idNf){
        return notaFiscalRepository.findById(idNf).get();
    }
}
