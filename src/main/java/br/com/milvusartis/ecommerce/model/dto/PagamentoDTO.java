package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    private Long idPagamento;
    private String titularPagamento;
    private String telefoneTitular;
    private String cpfTitular;
    private String formaPagamento;
    private Boolean isAprovado;


}
