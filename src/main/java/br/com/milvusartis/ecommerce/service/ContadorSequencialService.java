package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.NotaFiscal;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContadorSequencialService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Autowired
    ContadorSequencialService contadorSequencialService;

    public Integer contador() {
        List<NotaFiscal> lista = notaFiscalRepository.findAll();

        Integer contador = lista.size();

        return contador;
    }

    public Integer numerarNotaFiscal() {
        Integer contador = contadorSequencialService.contador();
        contador++;

        return contador;
    }
}
