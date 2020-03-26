package br.com.milvusartis.ecommerce.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long idProduto;

    @Column(name = "nm_produto")
    private String nome;

    @Column(name = "ds_produto")
    private String descricao;

    @Column(name = "ds_local_imagem")
    private String imagem;

    @Column(name = "vl_unitario_produto")
    private Double vlUnitario;

    @Column(name = "cd_disponibilidade_produto")
    private Boolean disponibilidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "id_estoque")
    private Estoque estoque;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name="nrItemPedido")
    private PedidoItem pedidoItem;

}
