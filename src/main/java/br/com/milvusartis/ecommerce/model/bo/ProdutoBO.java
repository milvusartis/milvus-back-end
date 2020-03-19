package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.CategoriaDTO;
import br.com.milvusartis.ecommerce.model.dto.EstoqueDTO;
import br.com.milvusartis.ecommerce.model.dto.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.entity.Categoria;
import br.com.milvusartis.ecommerce.model.entity.Estoque;
import br.com.milvusartis.ecommerce.model.entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBO implements IBO<Produto, ProdutoDTO> {

    @Autowired
    private CategoriaBO categoriaBO;

    @Autowired
    private EstoqueBO estoqueBO;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProdutoDTO parseToDTO(Produto pojo) {
        ProdutoDTO produtoDTO = modelMapper.map(pojo, ProdutoDTO.class);
//        CategoriaDTO categoriaDTO = categoriaBO.parseToDTO(pojo.getCategoria());
//        EstoqueDTO estoqueDTO = estoqueBO.parseToDTO(pojo.getEstoque());
//        produtoDTO.setCategoria(categoriaDTO);
//        produtoDTO.setEstoque(estoqueDTO);

//        ProdutoDTO produtoDTO =  new ProdutoDTO(
//                pojo.getIdProduto(),
//                pojo.getNome(),
//                pojo.getDescricao(),
//                pojo.getImagem(),
//                pojo.getValorUnitario(),
//                pojo.getDisponibilidade(),
//                categoriaBO.parseToDTO(pojo.getCategoria()),
//                estoqueBO.parseToDTO(pojo.getEstoque()));

        return produtoDTO;
    }

    @Override
    public Produto parseToPOJO(ProdutoDTO dto) {
        Produto produto = modelMapper.map(dto, Produto.class);
//        Categoria categoria = categoriaBO.parseToPOJO(dto.getCategoria());
//        Estoque estoque = estoqueBO.parseToPOJO(dto.getEstoque());

//        produto.setCategoria(categoria);
//        produto.setEstoque(estoque);

//        Produto produto = new Produto(
//                dto.getCodigo(),
//                dto.getNome(),
//                dto.getDescricao(),
//                dto.getImagem(),
//                dto.getValor(),
//                dto.getDisponibilidade(),
//                categoriaBO.parseToPOJO(dto.getCategoria()),
//                estoqueBO.parseToPOJO(dto.getEstoque())
//        );

        return produto;
    }
}

