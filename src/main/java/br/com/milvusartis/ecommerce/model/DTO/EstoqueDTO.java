package br.com.milvusartis.ecommerce.model.DTO;

import br.com.milvusartis.ecommerce.model.Estoque;
import br.com.milvusartis.ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {
    private ProdutoDTO produto;
    private Integer qtdestoque;
    private Integer qtdreservada;

    public static EstoqueDTO transformaEmDTO(Estoque e){

        return new EstoqueDTO(ProdutoDTO.transformaEmDTO(e.getProduto()), e.getQuantidadeEstoque(), e.getQuantidadeReservada());
    }

    //TODO WIP
//    public Estoque trasnsformaParaEstoque(){
//        return new Estoque(produto.trasnsformaParaProduto(), qtdestoque, qtdreservada);
//    }



}
