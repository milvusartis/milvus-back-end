package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemDTO {

    private Long id;
    private Integer quantidade;
    private Double valorProduto;
    private ProdutoDTO produto;
    private PedidoDTO pedido;

}