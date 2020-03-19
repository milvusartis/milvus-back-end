package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long idPedido;
    private Long nrPedido;
    private Date dtPedido;
    private BigDecimal vlFrete;
//    private Cliente cliente;
    private Long idCliente;
    private String dsStatusPedido;
    private BigDecimal vlTotal;
    private Integer nrCartao;
    private String nmCartao;
    private Date dtValidadeCartao;
    private Integer cdSegurancaCartao;
    private Date dtEntrega;
    private List<PedidoItem> pedidoItemPedido;

}