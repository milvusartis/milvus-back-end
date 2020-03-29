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
    @Column(name="id_pedido_item")
    private Long id;

    @Column(name="nr_quantidade")
    private Integer quantidade;

    @Column(name="vl_produto")
    private Double valorProduto;

    @OneToOne
    @JoinColumn(name="produto_id", referencedColumnName = "id_produto")
    private Produto produto;

//
//    @ManyToOne
//    @JoinColumn(name = "pedido_id", referencedColumnName = "id_pedido")
//    private Pedido  pedido;


    public double calculaValorPorItens(){
        return this.valorProduto * quantidade;
    }

}