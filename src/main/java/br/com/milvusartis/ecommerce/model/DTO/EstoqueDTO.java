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
    private Long id;
    private ProdutoDTO produto;
    private Integer qtdestoque;
    private Integer qtdreservada;

    public static EstoqueDTO transformaEmDTO(Estoque e){
        return new EstoqueDTO(e.getId(), ProdutoDTO.transformaEmDTO(e.getProduto()), e.getQuantidadeEstoque(), e.getQuantidadeReservada());
    }

    public Estoque trasnsformaParaEstoque(){
        return new Estoque(id, produto.trasnsformaParaProduto(), qtdestoque, qtdreservada);
    }



}
