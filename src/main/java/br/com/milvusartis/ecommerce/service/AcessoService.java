package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Acesso;
import br.com.milvusartis.ecommerce.model.tipos.Regra;
import br.com.milvusartis.ecommerce.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AcessoService")
public class AcessoService {

    @Autowired
    AcessoRepository acessoRepository;

    public Acesso salvar(Acesso acesso) {
        return acessoRepository.save(acesso);
    }

    public Acesso buscaPorId(Long idAcesso) {
        return acessoRepository.findById(idAcesso).get();
    }

    public List<Acesso> buscarAcesso(Long id, Regra regra) {

        List<Acesso> lista = new ArrayList<>();

        if (id == null && regra == null)
            lista = acessoRepository.findAll();
        else if (id != null)
            lista.add(acessoRepository.findById(id).get());
        else if (regra != null)
            lista = acessoRepository.findByRegra(regra);

        return lista;

    }

    public void excluirPorId(Long id) {
        acessoRepository.deleteById(id);
    }

    public Acesso alterar(Acesso acesso) {

        Acesso acessoEntity = acessoRepository.getOne(acesso.getIdAcesso());

        acessoEntity.setRegra(acesso.getRegra());

        return acessoRepository.save(acessoEntity);

    }

    public Acesso alterarCamposEspecificos(Acesso acesso) {
        return this.alterar(acesso);
    }

}
