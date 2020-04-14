package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.ClienteCadastroDTO;
import br.com.milvusartis.ecommerce.model.dto.ClienteDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteCadastroBO implements IBO<Cliente, ClienteCadastroDTO>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteCadastroDTO parseToDTO(Cliente pojo) {
        ClienteCadastroDTO clienteDTO = modelMapper.map(pojo, ClienteCadastroDTO.class);
        return clienteDTO;
    }

    @Override
    public Cliente parseToPOJO(ClienteCadastroDTO dto) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        return cliente;
    }

}