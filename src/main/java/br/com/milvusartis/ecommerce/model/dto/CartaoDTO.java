package br.com.milvusartis.ecommerce.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {
    private String numeroCartao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;
    private String ccv;

}
