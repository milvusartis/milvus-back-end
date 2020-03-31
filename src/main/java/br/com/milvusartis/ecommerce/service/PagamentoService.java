package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Pagamento;
import br.com.milvusartis.ecommerce.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PagamentoService")
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscaPorId(Long idPagamento) {
        return pagamentoRepository.findById(idPagamento).get();
    }

    public List<Pagamento> buscarPagamento(Long id, Boolean isAprovado) {

        List<Pagamento> lista = new ArrayList<>();

        if (id == null && isAprovado == null)
            lista = pagamentoRepository.findAll();
        else if (id != null)
            lista.add(pagamentoRepository.findById(id).get());
        else if (isAprovado != null)
            lista = pagamentoRepository.findByIsAprovado(isAprovado);

        return lista;

    }

    public void excluirPorId(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public Pagamento alterar(Pagamento pagamento) {

        Pagamento pagamentoEntity = pagamentoRepository.getOne(pagamento.getIdPagamento());

        pagamentoEntity.setTitularPagamento(pagamento.getTitularPagamento());
        pagamentoEntity.setTelefoneTitular(pagamento.getTelefoneTitular());
        pagamentoEntity.setCpfTitular(pagamento.getCpfTitular());
        pagamentoEntity.setFormaPagamento(pagamento.getFormaPagamento());
        pagamentoEntity.setIsAprovado(pagamento.getIsAprovado());

        return pagamentoRepository.save(pagamentoEntity);

    }

    public Pagamento alterarCamposEspecificos(Pagamento pagamento) {
        return this.alterar(pagamento);
    }

}