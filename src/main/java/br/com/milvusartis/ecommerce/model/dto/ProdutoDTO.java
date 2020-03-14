package br.com.milvusartis.ecommerce.model.DTO;

import br.com.milvusartis.ecommerce.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private Double valor;
    private Boolean disponibilidade;
    private Categoria categoria;
}
