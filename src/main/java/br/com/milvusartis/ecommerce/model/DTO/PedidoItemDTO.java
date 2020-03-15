package br.com.milvusartis.ecommerce.model.DTO;

import br.com.milvusartis.ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemDTO {

    private Long nrItemPedido;
    private Long idPedido;
    private Produto idProduto;
    private BigDecimal vlProduto;
}
