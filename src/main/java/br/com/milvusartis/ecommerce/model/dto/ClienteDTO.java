package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long idCliente;
    private String nmCliente;
    private String dsCpf;
    private String dsTelefone;
    private String dsEmail;
    private String dsSenha;
    private Endereco endereco;

}
