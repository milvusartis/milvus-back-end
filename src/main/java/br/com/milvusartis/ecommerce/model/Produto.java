package br.com.milvusartis.ecommerce.model;

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
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @NotNull
    @Column(name = "nm_produto")
    private String nome;
    @NotNull
    @Column(name = "ds_produto")
    private String descricao;
    @NotNull
    @Column(name = "ds_local_imagem")
    private String imagem;
    @NotNull
    @Column(name = "vl_unitario_produto")
    private Double valorUnitario;
    @Column(name = "cd_disponibilidade_produto")
    private Boolean disponibilidade;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
//    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
//    private Estoque estoque;

    @Column(name = "nr_quantidade_estocado")
    private Integer quantidadeEstoque;
    @Column(name = "nr_qauntidade_reservado")
    private Integer quantidadeReservada;
}
