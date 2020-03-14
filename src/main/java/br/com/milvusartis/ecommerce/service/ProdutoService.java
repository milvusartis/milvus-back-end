package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.DTO.CategoriaDTO;
import br.com.milvusartis.ecommerce.model.DTO.ProdutoDTO;
import br.com.milvusartis.ecommerce.model.Produto;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProdutoService")
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ResponseEntity salvar(ProdutoDTO produtoDTO) {
        Produto produtoEntity = new Produto();
        produtoEntity.setNome(produtoDTO.getNome());
        produtoEntity.setDescricao(produtoDTO.getDescricao());
        produtoEntity.setValorUnitario(produtoDTO.getValor());
        produtoEntity.setImagem(produtoDTO.getImagem());
        produtoEntity.setDisponibilidade(produtoDTO.getDisponibilidade());
        produtoEntity.setCategoria(produtoDTO.getCategoria());

        return ResponseEntity.ok().body(produtoRepository.save(produtoEntity));
    }

    public ResponseEntity<List<ProdutoDTO>> listar() {
        List<Produto> listaDeProdutos = produtoRepository.findAll();
        List<ProdutoDTO> listaDeProdutosDTO = new ArrayList<>();

        for (Produto prod : listaDeProdutos ){
            ProdutoDTO produtoDTO = new ProdutoDTO();

            produtoDTO.setId(prod.getIdProduto());
            produtoDTO.setNome(prod.getNome());
            produtoDTO.setDescricao(prod.getDescricao());
            produtoDTO.setValor(prod.getValorUnitario());
            produtoDTO.setDisponibilidade(prod.getDisponibilidade());
            produtoDTO.setImagem(prod.getImagem());

//            produtoDTO.setCategoria();
            listaDeProdutosDTO.add(produtoDTO);
        }




        return ResponseEntity.ok().body(listaDeProdutosDTO);
    }


    public ResponseEntity<Produto> buscarProdutoPorID(Long id) {
        return ResponseEntity.ok().body(produtoRepository.findById(id).get());
    }

    public ResponseEntity<Produto> atualizar(ProdutoDTO produtoDTO) {
        Produto produtoEntity = produtoRepository.getOne(produtoDTO.getId());
        produtoEntity.setDescricao(produtoDTO.getDescricao());
        produtoEntity.setValorUnitario(produtoDTO.getValor());



        produtoDTO.setCategoria(produtoDTO.getCategoria());
        return ResponseEntity.ok().body(produtoRepository.save(produtoEntity));
    }

    public void excluirProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }

//    @DeleteMapping("/produto")
//    public void excluirProduto(@RequestBody Produto produto) {
//        repository.delete(produto);
//    }

//

}
