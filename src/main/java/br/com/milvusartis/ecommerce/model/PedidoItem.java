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
    @Column(name="nr_item_pedido")
    private Long nrItemPedido;

    //@NotNull
    //@Column(name="id_produto")
    //private Long idProduto;

    @NotNull
    @Column(name="vl_produto")
    private BigDecimal vlProduto;


    //na tb_produto:
    //@OneToOne
    //@JoinColumn(name="produto")
    //private List<PedidoItem> pedidoItemProduto;

    //ao finalizar pedido, voltar contador para 1 para proximo pedido
    //FALAR COM LEO SOBRE NRPRODUTOPEDIDO
}