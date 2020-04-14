package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.ProdutoListarDTO;
import br.com.milvusartis.ecommerce.model.entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoListarBO implements IBO<Produto, ProdutoListarDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProdutoListarDTO parseToDTO(Produto pojo) {
        ProdutoListarDTO produtoDTO = modelMapper.map(pojo, ProdutoListarDTO.class);
        return produtoDTO;
    }

    @Override
    public Produto parseToPOJO(ProdutoListarDTO dto) {
        Produto produto = modelMapper.map(dto, Produto.class);
        return produto;
    }

}