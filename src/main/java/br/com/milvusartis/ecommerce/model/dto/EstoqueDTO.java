package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {

    private Long idEstoque;
    private Integer quantidadeEstoque;
    private Integer quantidadeReservada;
}
