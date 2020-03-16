package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(name="nr_quantidade")
    private Integer nrQuantidade;

    @Column(name="vl_produto")
    private Double vlProduto;

    public double calc(){
        return this.vlProduto * nrQuantidade;
    }

}