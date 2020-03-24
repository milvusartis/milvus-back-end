package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemDTO {

    private Long nrItemPedido;
    private Long idPedido;
    private Produto idProduto;
    private Integer nrQuantidade;
    private Double vlProduto;

}