package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.tipos.Regra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long idUsuario;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String senha;
    private Regra regraDeAcesso;
}
