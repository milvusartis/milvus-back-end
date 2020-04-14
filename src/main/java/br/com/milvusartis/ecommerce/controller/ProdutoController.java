package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.ProdutoBO;
import br.com.milvusartis.ecommerce.model.dto.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.entity.Categoria;
import br.com.milvusartis.ecommerce.model.entity.Produto;
import br.com.milvusartis.ecommerce.repository.CategoriaRepository;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import br.com.milvusartis.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoBO produtoBO;

    @Autowired
    CategoriaRepository categoriaRepository;


//    @GetMapping("/produtos")
//    public ResponseEntity<?> listar() {
//        List<Produto> ListaProdutos = repository.findAll();
//        List<ProdutoDTO> listaDeProdutosResposta = new ArrayList<>();
//
//        ListaProdutos.forEach((produto) -> {
//            listaDeProdutosResposta.add(produtoBO.parseToDTO(produto));
//        });
//        return ResponseEntity.status(HttpStatus.OK).body(listaDeProdutosResposta);
//    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/produtos")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoDTO produtoDTO) {
        if (produtoDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não pode estar vazio");
        }

//        Produto produto = ProdutoService.inicializaAtributosProduto(produtoBO.parseToPOJO(produtoDTO));
//        Produto produtoEntity = produtoRepository.save(produto);

        Produto produtoEntity = produtoRepository.save(produtoBO.parseToPOJO(produtoDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoBO.parseToDTO(produtoEntity));

    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {
        Optional<Produto> opt_produto = produtoRepository.findById(id);
        Produto produto = opt_produto.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return ResponseEntity.status(HttpStatus.OK).body(produtoBO.parseToDTO(produto));
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produtoRepository.delete(produto);
                    return ResponseEntity.status(HttpStatus.OK).body("Produto excluido");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping(path = "/produtos")
    Page<ProdutoDTO> loadProdutoPage(
//            @PageableDefault(page = 0, size = 5)
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "idProduto", direction = Sort.Direction.ASC)
            })
                    Pageable pageable) {

        Page<Produto> page = produtoRepository.findAllPage(pageable);

        return new PageImpl<ProdutoDTO>(page
                .stream()
                .map(produto -> produtoBO.parseToDTO(produto))
                .collect(Collectors.toList()), pageable, page.getTotalElements());
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/admin/produtos/{id}")
    public ResponseEntity<?> modificar(@PathVariable("id") Long id, @RequestBody Produto edicao) {

        Optional<Produto> opt_produto = produtoRepository.findById(id);
        Produto produto = opt_produto.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));


//        Long idEstoqueEdicao = edicao.getEstoque().getIdEstoque();

        if(edicao.getNome() != "")
            produto.setNome(edicao.getNome());

        if(edicao.getDescricao() != "")
            produto.setDescricao(edicao.getDescricao());

        if(edicao.getImagem() != "")
            produto.setImagem(edicao.getImagem());

        if(edicao.getValorUnitario() != null)
            produto.setValorUnitario(edicao.getValorUnitario());

        if(edicao.getIsAtivo() != null)
            produto.setIsAtivo(edicao.getIsAtivo());

        if(edicao.getCategoria().getIdCategoria() != null && edicao.getCategoria().getIdCategoria() != produto.getCategoria().getIdCategoria()) {

            Optional<Categoria> opt_categoria = categoriaRepository.findById(edicao.getCategoria().getIdCategoria());
            Categoria categoria = opt_categoria.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
            produto.setCategoria(categoria);
        }

//            if(edicao.getEstoque().getQtdEstocada() != null)
//                produto.getEstoque().setQtdEstocada(edicao.getEstoque().getQtdEstocada());
//
//            if(edicao.getEstoque().getQtdReservada() != null)
//                produto.getEstoque().setQtdReservada(edicao.getEstoque().getQtdReservada());

        produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoBO.parseToDTO(produto));

    }

}
