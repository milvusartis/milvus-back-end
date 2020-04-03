package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPedido;
    private Double valorFrete;
    private Double valorTotal;
    private StatusPedido statusPedido;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEntrega;
    private List<PedidoItemDTO> pedidoItens;
    private ClienteResponseDTO cliente;
    private PagamentoDTO pagamento;

}