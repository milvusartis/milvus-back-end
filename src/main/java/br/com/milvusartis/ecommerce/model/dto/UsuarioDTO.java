package br.com.milvusartis.ecommerce.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotEmpty(message = "Preenchimento obrigatório")
    private String nome;

    @Column(name = "ds_email")
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Column(name = "ds_senha")
    private String senha;


}