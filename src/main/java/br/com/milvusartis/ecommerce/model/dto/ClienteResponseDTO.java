package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Long idCliente;
    private String cpf;
    private String rg;
    private String telefone;
    private UsuarioResponseDTO usuario;
    private EnderecoDTO endereco;

}