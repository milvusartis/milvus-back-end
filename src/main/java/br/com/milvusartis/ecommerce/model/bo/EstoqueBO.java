package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.CategoriaDTO;
import br.com.milvusartis.ecommerce.model.dto.EstoqueDTO;
import br.com.milvusartis.ecommerce.model.entity.Estoque;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueBO implements IBO<Estoque, EstoqueDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EstoqueDTO parseToDTO(Estoque pojo) {
        EstoqueDTO estoqueDTO = modelMapper.map(pojo, EstoqueDTO.class);

//        return new EstoqueDTO(
//                pojo.getIdEstoque(),
//                pojo.getQuantidadeEstoque(),
//                pojo.getQuantidadeReservada());

        return estoqueDTO;
    }

    @Override
    public Estoque parseToPOJO(EstoqueDTO dto) {
        Estoque estoque = modelMapper.map(dto, Estoque.class);

//        return new Estoque(
//                dto.getIdEstoque(),
//                dto.getQuantidadeEstoque(),
//                dto.getQuantidadeReservada());
//    }
        return estoque;
    }
}
