package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.EnderecoDTO;
import br.com.milvusartis.ecommerce.model.entity.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoBO implements IBO<Endereco, EnderecoDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EnderecoDTO parseToDTO(Endereco pojo) {
        EnderecoDTO enderecoDTO = modelMapper.map(pojo, EnderecoDTO.class);
        return enderecoDTO;
    }

    @Override
    public Endereco parseToPOJO(EnderecoDTO dto) {
        Endereco endereco = modelMapper.map(dto, Endereco.class);
        return endereco;
    }

}