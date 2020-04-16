package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.dto.ContatoDTO;
import br.com.milvusartis.ecommerce.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @PostMapping("/enviarcontato")
    public ResponseEntity<?> enviarContato(@RequestBody ContatoDTO contatoDTO) {

        if(contatoDTO != null) {
            contatoService.enviarEmailContato(contatoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Email enviado com sucesso.");
        }
        else
            return ResponseEntity.status(HttpStatus.OK).body("Falha ao enviar email");
    }
}
