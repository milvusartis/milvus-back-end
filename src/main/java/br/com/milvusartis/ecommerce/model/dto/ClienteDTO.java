package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long idCliente;
    @CPF
    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpf;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String rg;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String telefone;
    private UsuarioDTO usuario;
    private EnderecoDTO endereco;

}