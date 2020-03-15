package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.Cliente;
import br.com.milvusartis.ecommerce.model.Empresa;
import br.com.milvusartis.ecommerce.model.Pedido;
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
    private Cliente cliente;
    private Empresa empresa;
    private Pedido pedido;
    private String naturezaOperacao;
    private Integer nfe;
}