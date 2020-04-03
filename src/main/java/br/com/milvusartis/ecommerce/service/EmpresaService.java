package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Empresa;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("EmpresaService")
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa buscaPorId(Long idEmpresa) {
        return empresaRepository.findById(idEmpresa).get();
    }

    public List<Empresa> buscarEmpresa(Long id, String cnpj) {

        List<Empresa> lista = new ArrayList<>();

        if (id == null && cnpj == null)
            lista = empresaRepository.findAll();
        else if (id != null)
            lista.add(empresaRepository.findById(id).get());
        else if (cnpj != null)
            lista = empresaRepository.findByCnpj(cnpj);

        return lista;

    }

    public void excluirPorId(Long id) {
        empresaRepository.deleteById(id);
    }

    public Empresa alterar(Empresa empresa) {

        Empresa empresaEntity = empresaRepository.getOne(empresa.getIdEmpresa());

        empresaEntity.setRazaoSocial(empresa.getRazaoSocial());
        empresaEntity.setCnpj(empresa.getCnpj());
        empresaEntity.setInscricaoEstadual(empresa.getInscricaoEstadual());
        empresaEntity.setEndereco(empresa.getEndereco());

        return empresaRepository.save(empresaEntity);

    }

    public Empresa alterarCamposEspecificos(Empresa empresa) {
        return this.alterar(empresa);
    }

}