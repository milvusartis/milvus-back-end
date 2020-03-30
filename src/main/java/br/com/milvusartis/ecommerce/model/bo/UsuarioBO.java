package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.UsuarioDTO;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBO implements IBO<Usuario, UsuarioDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO parseToDTO(Usuario pojo) {
        UsuarioDTO usuarioDTO = modelMapper.map(pojo, UsuarioDTO.class);
        return usuarioDTO;
    }

    @Override
    public Usuario parseToPOJO(UsuarioDTO dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        return usuario;
    }

}