package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.AcessoDTO;
import br.com.milvusartis.ecommerce.model.entity.Acesso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcessoBO implements IBO<Acesso, AcessoDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AcessoDTO parseToDTO(Acesso pojo) {
        AcessoDTO acessoDTO = modelMapper.map(pojo, AcessoDTO.class);
        return acessoDTO;
    }

    @Override
    public Acesso parseToPOJO(AcessoDTO dto) {
        Acesso acesso = modelMapper.map(dto, Acesso.class);
        return acesso;
    }

}