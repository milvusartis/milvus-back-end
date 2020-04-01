package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.NotaFiscal;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("NotaFiscalService")
public class NotaFiscalService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    public NotaFiscal salvar(NotaFiscal notaFiscal) {
        return notaFiscalRepository.save(notaFiscal);
    }

    public NotaFiscal buscaPorId(Long idNotaFiscal) {
        return notaFiscalRepository.findById(idNotaFiscal).get();
    }

    public List<NotaFiscal> buscarNotaFiscal(Long id, Integer numeroNf) {

        List<NotaFiscal> lista = new ArrayList<>();

        if (id == null && numeroNf == null)
            lista = notaFiscalRepository.findAll();
        else if (id != null)
            lista.add(notaFiscalRepository.findById(id).get());
        else if (numeroNf != null)
            lista = notaFiscalRepository.findByNumeroNf(numeroNf);

        return lista;

    }

    public void excluirPorId(Long id) {
        notaFiscalRepository.deleteById(id);
    }

    public NotaFiscal alterar(NotaFiscal notaFiscal) {

        NotaFiscal notaFiscalEntity = notaFiscalRepository.getOne(notaFiscal.getIdNotaFiscal());

        notaFiscalEntity.setNumeroNf(notaFiscal.getNumeroNf());
        notaFiscalEntity.setDataEmissao(notaFiscal.getDataEmissao());
        notaFiscalEntity.setNaturezaOperacao(notaFiscal.getNaturezaOperacao());

        return notaFiscalRepository.save(notaFiscalEntity);

    }

    public NotaFiscal alterarCamposEspecificos(NotaFiscal notaFiscal) {
        return this.alterar(notaFiscal);
    }

}