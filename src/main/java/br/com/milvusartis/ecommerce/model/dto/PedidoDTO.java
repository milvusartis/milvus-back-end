package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long idPedido;
//    private Integer numero;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPedido;
    private Double valorFrete;
    private Double valorTotal;
    private StatusPedido statusPedido;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;
    private Integer diasParaEntrega;
    private List<PedidoItemDTO> pedidoItens;
    private ClienteResponseDTO cliente;
    private PagamentoDTO pagamento;

}