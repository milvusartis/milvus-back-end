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
@Table(name="tb_pedido_item")
public class PedidoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nr_item_pedido")
    private Long nrItemPedido;

    @Column(name="nr_quantidade")
    private Integer quantidade;

    @Column(name="vl_produto")
    private Double vlProduto;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name="id_produto")
    private Produto produto;

//    public double calc(){
//        return this.vlProduto * quantidade;
//    }

}