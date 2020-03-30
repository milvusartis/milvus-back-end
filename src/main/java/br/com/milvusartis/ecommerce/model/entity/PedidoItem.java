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
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_item")
    private Long idPedidoItem;

    @Column(name = "nr_quantidade")
    private Integer quantidade;

    @Column(name = "vl_preco_vendido")
    private Double precoVendido;

    @OneToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id_produto")
    private Produto produto;

//    @ManyToOne
//    @JoinColumn(name = "pedido_id", referencedColumnName = "id_pedido")
//    private Pedido pedido;

    public double calculaValorPorItens(){
        return this.precoVendido * this.quantidade;
    }

}