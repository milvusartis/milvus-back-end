package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBO implements IBO<Produto, ProdutoDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProdutoDTO parseToDTO(Produto pojo) {
        ProdutoDTO produtoDTO = modelMapper.map(pojo, ProdutoDTO.class);
        return produtoDTO;
    }

    @Override
    public Produto parseToPOJO(ProdutoDTO dto) {
        Produto produto = modelMapper.map(dto, Produto.class);
        return produto;
    }

}