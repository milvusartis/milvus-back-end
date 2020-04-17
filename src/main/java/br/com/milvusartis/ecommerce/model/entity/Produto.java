package br.com.milvusartis.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @NotNull
    @Column(name = "ds_nome_produto")
    private String nome;

    @NotNull
    @Column(name = "ds_descricao")
    private String descricao;

    @NotNull
    @Column(name = "ds_imagem_url")
    private String imagem;

    @NotNull
    @Column(name = "vl_unitario")
    private Double valorUnitario;

    @NotNull
    @Column(name = "cd_ativo")
    private Boolean isAtivo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    private Categoria categoria;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "estoque_id", referencedColumnName = "id_estoque")
//    private Estoque estoque;

}
