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
    @Column(name="id_pedido")
    private Long idPedido;

    @Id
    @Column(name="nr_pedido")
    private Integer nrPedido;

    @NotNull
    @Column(name="nr_produto_pedido")
    private Integer nrProdutoPedido;

    @NotNull
    @Column(name="vl_produto")
    private BigDecimal vlProduto;

    @NotNull
    @JoinColumn(name="id_produto")
    private Long idProduto;

}