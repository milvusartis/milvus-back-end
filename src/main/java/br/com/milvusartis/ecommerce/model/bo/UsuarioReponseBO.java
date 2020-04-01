package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;
import br.com.milvusartis.ecommerce.model.dto.ClienteResponseDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioReponseBO implements IBO<Cliente, ClienteResponseDTO>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteResponseDTO parseToDTO(Cliente pojo) {
        ClienteResponseDTO clienteResponseDTO = modelMapper.map(pojo, ClienteResponseDTO.class);
        return clienteResponseDTO;
    }

    @Override
    public Cliente parseToPOJO(ClienteResponseDTO dto) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        return cliente;
    }

}