package br.com.milvusartis.ecommerce.Service;

import br.com.milvusartis.ecommerce.model.DTO.EmpresaDTO;
import br.com.milvusartis.ecommerce.model.Empresa;
import br.com.milvusartis.ecommerce.model.Endereco;
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
}
