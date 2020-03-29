package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscalDTO {

    private Long idNotaFiscal;
    private Integer numeroNf;
    private Date dataEmissao;
    private String naturezaOperacao;
    private PedidoDTO pedido;
    private EmpresaDTO empresa;




}
