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

    @Column(name="vl_produto")
    private BigDecimal vlProduto;

    public Long getNrItemPedido() {
        return nrItemPedido;
    }

    public void setNrItemPedido(Long nrItemPedido) {
        this.nrItemPedido = nrItemPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(BigDecimal vlProduto) {
        this.vlProduto = vlProduto;
    }
}