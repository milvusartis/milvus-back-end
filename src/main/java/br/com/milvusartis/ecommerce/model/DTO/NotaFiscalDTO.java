package br.com.milvusartis.ecommerce.model.DTO;

import br.com.milvusartis.ecommerce.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscalDTO {
    private Long idNf;
    private Date data;
    private Long idCliente;
    //private Cliente cliente;
    private Empresa empresa;
    private Long idPedido;
    //private Pedido pedido;
    private String naturezaOperacao;
    private Integer nfe;
}
