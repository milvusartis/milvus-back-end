package br.com.milvusartis.ecommerce.model.DTO;

import br.com.milvusartis.ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long codigo;
    private String nome;
    private String descricao;
    private String imagem;
    private Double valor;
    private Boolean disponibilidade;
    private CategoriaDTO categoria;


//    public static ProdutoDTO transformaEmDTO(Produto p){
//
//        return new ProdutoDTO(p.getIdProduto(), p.getNome(), p.getDescricao(), p.getImagem(), p.getValorUnitario(), p.getDisponibilidade(), CategoriaDTO.transformaEmDTO(p.getCategoria()), EstoqueDTO.transformaEmDTO(p.getEstoque()));
//    }
////TODO Dando erro ao consultar estoque
//    public Produto trasnsformaParaProduto(){
//        return new Produto(codigo, nome, descricao, imagem, valor, disponibilidade, categoria.transformaParaCategoria(),estoque.trasnsformaParaEstoque());
//    }


}
