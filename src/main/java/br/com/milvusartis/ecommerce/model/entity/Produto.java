package br.com.milvusartis.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Long id;

    @Column(name = "ds_nome_produto")
    private String nome;

    @Column(name = "ds_descricao")
    private String descricao;

    @Column(name = "ds_imagem_url")
    private String imagem;

    @Column(name = "vl_unitario")
    private Double valorUnitario;

    @Column(name = "cd_ativo")
    private Boolean isAtivo;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoque_id", referencedColumnName = "id_estoque")
    private Estoque estoque;



}
