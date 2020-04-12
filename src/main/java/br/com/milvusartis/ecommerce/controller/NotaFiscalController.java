package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.NotaFiscalBO;
import br.com.milvusartis.ecommerce.model.dto.NotaFiscalDTO;
import br.com.milvusartis.ecommerce.model.dto.PedidoDTO;
import br.com.milvusartis.ecommerce.model.entity.NotaFiscal;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import br.com.milvusartis.ecommerce.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class NotaFiscalController {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Autowired
    NotaFiscalBO notaFiscalBO;

    @Autowired
    NotaFiscalService notaFiscalService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/notasfiscais")
    public ResponseEntity<?> listar() {
        List<NotaFiscal> listaNotaFiscal = notaFiscalRepository.findAll();
        List<NotaFiscalDTO> listaDeNotaFiscalDTO = new ArrayList<>();

        listaNotaFiscal.forEach((notaFiscal) -> {
            listaDeNotaFiscalDTO.add(notaFiscalBO.parseToDTO(notaFiscal));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDeNotaFiscalDTO);

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/notasfiscais/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<NotaFiscal> opt_notaFiscal = notaFiscalRepository.findById(id);
        NotaFiscal notaFiscal = opt_notaFiscal.orElseThrow(() -> new ResourceNotFoundException("Nota fiscal não encontrada"));

        return ResponseEntity.status(HttpStatus.OK).body(notaFiscalBO.parseToDTO(notaFiscal));

    }

}
