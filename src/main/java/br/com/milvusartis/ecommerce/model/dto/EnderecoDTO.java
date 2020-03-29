package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long id;
    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

}