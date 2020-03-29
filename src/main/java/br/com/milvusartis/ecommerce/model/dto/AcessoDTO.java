package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.tipos.Regra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcessoDTO {

    private Long id;
    private Regra regra;
}
