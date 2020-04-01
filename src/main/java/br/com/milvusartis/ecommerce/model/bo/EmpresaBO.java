package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.EmpresaDTO;
import br.com.milvusartis.ecommerce.model.entity.Empresa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpresaBO implements IBO<Empresa, EmpresaDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmpresaDTO parseToDTO(Empresa pojo) {
        EmpresaDTO empresaDTO = modelMapper.map(pojo, EmpresaDTO.class);
        return empresaDTO;
    }

    @Override
    public Empresa parseToPOJO(EmpresaDTO dto) {
        Empresa empresa = modelMapper.map(dto, Empresa.class);
        return empresa;
    }

}