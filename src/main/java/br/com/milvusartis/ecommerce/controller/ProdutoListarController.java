package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.bo.ProdutoListarBO;
import br.com.milvusartis.ecommerce.model.dto.ProdutoListarDTO;
import br.com.milvusartis.ecommerce.model.entity.Produto;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class ProdutoListarController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoListarBO produtoListarBO;

    @GetMapping(path = "/listarprodutos")
    Page<ProdutoListarDTO> loadProdutoPage(
//            @PageableDefault(page = 0, size = 5)
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "idProduto", direction = Sort.Direction.ASC)
            })
                    Pageable pageable) {

        Page<Produto> page = produtoRepository.findAllPage(pageable);

        return new PageImpl<ProdutoListarDTO>(page
                .stream()
                .map(produto -> produtoListarBO.parseToDTO(produto))
                .collect(Collectors.toList()), pageable, page.getTotalElements());
    }
}
