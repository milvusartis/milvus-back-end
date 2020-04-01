package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long idCliente;
    private String cpf;
    private String rg;
    private String telefone;
    private UsuarioDTO usuario;
    private EnderecoDTO endereco;

}