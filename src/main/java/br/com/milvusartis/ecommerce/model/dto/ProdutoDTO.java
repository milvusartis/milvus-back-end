package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long idProduto;
    private String nome;
    private String descricao;
    private String imagem;
    private Double valorUnitario;
    private Boolean disponibilidade;
    private Long categoriaId;
    private String categoriaDescricao;
    private Long estoqueIdEstoque;
    private Integer estoqueQuantidadeEstoque;
    private Integer estoqueQuantidadeReservada;

}
