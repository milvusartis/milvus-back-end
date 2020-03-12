package br.com.milvusartis.ecommerce.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
    private Long idEmpresa;
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
    private List<Long> idEndereco;
}
