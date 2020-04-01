package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.CategoriaDTO;
import br.com.milvusartis.ecommerce.model.entity.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaBO implements IBO<Categoria, CategoriaDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoriaDTO parseToDTO(Categoria pojo) {
        CategoriaDTO categoriaDTO = modelMapper.map(pojo, CategoriaDTO.class);
        return categoriaDTO;
    }

    @Override
    public Categoria parseToPOJO(CategoriaDTO dto) {
        Categoria categoria = modelMapper.map(dto, Categoria.class);
        return categoria;
    }

}