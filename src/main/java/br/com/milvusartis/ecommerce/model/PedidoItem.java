package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_pedido_item")
public class PedidoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nr_item_pedido")
    private Long nrItemPedido;

    @Column(name="id_pedido")
    private Long idPedido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_produto")
    private Produto idProduto;

    @NotNull
    @Column(name="vl_produto")
    private BigDecimal vlProduto;

}