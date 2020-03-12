package br.com.milvusartis.ecommerce.model.DTO;

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
    private Long idEmpresa;
    private Long idPedido;
    private String naturezaOperacao;
    private Integer nfe;
}
