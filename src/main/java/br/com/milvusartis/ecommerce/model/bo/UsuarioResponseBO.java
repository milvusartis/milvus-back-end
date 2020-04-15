package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.UsuarioDTO;
import br.com.milvusartis.ecommerce.model.dto.UsuarioResponseDTO;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioResponseBO implements IBO<Usuario, UsuarioResponseDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioResponseDTO parseToDTO(Usuario pojo) {
        UsuarioResponseDTO usuarioDTO = modelMapper.map(pojo, UsuarioResponseDTO.class);
        return usuarioDTO;
    }

    @Override
    public Usuario parseToPOJO(UsuarioResponseDTO dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        return usuario;
    }

}