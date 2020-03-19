package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.dto.EmpresaDTO;
import br.com.milvusartis.ecommerce.model.entity.Empresa;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("EmpresaService")
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;
    public ResponseEntity save(EmpresaDTO empresaDTO){
        Empresa empresaEntity = new Empresa();

        empresaEntity.setRazaoSocial(empresaDTO.getRazaoSocial());
        empresaEntity.setCnpj(empresaDTO.getCnpj());
        empresaEntity.setInscricaoEstadual(empresaDTO.getInscricaoEstadual());
        empresaEntity.setEndereco(empresaDTO.getEndereco());

        Empresa retornoEmpresa = empresaRepository.save(empresaEntity);
        empresaDTO.setIdEmpresa(retornoEmpresa.getIdEmpresa());
        return ResponseEntity.ok().body(empresaDTO);
    }
    public void deleteById(Long id){
        empresaRepository.deleteById(id);
    }
    public ResponseEntity alterar(Empresa empresa){
        Empresa empresaEntity = new Empresa();

        empresaEntity.setRazaoSocial(empresa.getRazaoSocial());
        empresaEntity.setCnpj(empresa.getCnpj());
        empresaEntity.setInscricaoEstadual(empresa.getInscricaoEstadual());
        empresaEntity.setEndereco(empresa.getEndereco());

        return ResponseEntity.ok().body(empresaRepository.save(empresaEntity));
    }
}
