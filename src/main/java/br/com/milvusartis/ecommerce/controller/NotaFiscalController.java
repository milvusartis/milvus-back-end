package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.NotaFiscal;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalController(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    @PostMapping("/create-nota-fiscal")
    public NotaFiscal save(@RequestBody NotaFiscal notaFiscal){
        return notaFiscalRepository.save(notaFiscal);
    }

    @GetMapping("/find-nota-fiscal/list")
    public List<NotaFiscal> find(){
        return notaFiscalRepository.findAll();
    }
}
