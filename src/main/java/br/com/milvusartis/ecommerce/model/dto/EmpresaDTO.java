package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {

    private Long idEmpresa;
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
    private EnderecoDTO endereco;

}