package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.NotaFiscalService;
import br.com.milvusartis.ecommerce.model.DTO.NotaFiscalDTO;
import br.com.milvusartis.ecommerce.model.NotaFiscal;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @PostMapping("/notaFiscal")
    public ResponseEntity save(@RequestBody NotaFiscalDTO notaFiscalDTO){
        return ResponseEntity.ok().body(notaFiscalService.save(notaFiscalDTO));
    }

//    @GetMapping("/find-nota-fiscal/list")
//    public List<NotaFiscal> find(){
//        return notaFiscalRepository.findAll();
//    }
}
