package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoListarDTO {

    private Long idProduto;
    private String nome;
    private String descricao;
    private String imagem;
    private Double valorUnitario;
    private Boolean isAtivo;
    private String categoriaNome;

}