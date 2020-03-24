package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteBO implements IBO<Cliente, ClienteDTO>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDTO parseToDTO(Cliente pojo) {
        ClienteDTO clienteDTO = modelMapper.map(pojo, ClienteDTO.class);
        return clienteDTO;
    }

    @Override
    public Cliente parseToPOJO(ClienteDTO dto) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        return cliente;
    }

}