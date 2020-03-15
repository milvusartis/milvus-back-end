package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.Service.NotaFiscalService;
import br.com.milvusartis.ecommerce.model.dto.NotaFiscalDTO;
import br.com.milvusartis.ecommerce.model.NotaFiscal;
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

    @PostMapping("/nf")
    public ResponseEntity save(@RequestBody NotaFiscalDTO notaFiscalDTO){
        return ResponseEntity.ok().body(notaFiscalService.save(notaFiscalDTO));
    }

    @GetMapping("/nf/")
    public List<NotaFiscal> find(){
        return notaFiscalRepository.findAll();
    }

    @GetMapping("/nf/{idnf}")
    public NotaFiscal findById(@PathVariable("idnf")Long idnf){
        return notaFiscalRepository.findById(idnf).get();
    }

    @DeleteMapping("/nf/{idnf}")
    public void deleteById(@PathVariable("idnf") Long idnf) {
        notaFiscalService.deleteById(idnf);
    }

    @PutMapping("/nf")
    public ResponseEntity alterar(@RequestBody NotaFiscal notaFiscal) {
        return ResponseEntity.ok().body(notaFiscalService.alterar(notaFiscal));
    }
}
