package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pagamento;
import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long idPedido;
    private Long numero;
    private Date dataPedido;
    private Double valorFrete;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Date dataEntrega;
    private ClienteDTO cliente;
    private PagamentoDTO pagamento;


}