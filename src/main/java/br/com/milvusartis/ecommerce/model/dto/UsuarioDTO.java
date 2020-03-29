package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.Acesso;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long idUsuario;
    private String nome;
    private String email;
    private ClienteDTO cliente;
    private AcessoDTO acesso;

}
