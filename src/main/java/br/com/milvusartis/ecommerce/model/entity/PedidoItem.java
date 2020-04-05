package br.com.milvusartis.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

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

    @Transient
    public Double getSubtotal(){
        return calculaValorPorItens();
    }
    public Double calculaValorPorItens(){
        return getPrecoVendido() * getQuantidade();
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        final StringBuilder sb = new StringBuilder();
        sb.append(getProduto().getNome());
        sb.append(", Qte: ");
        sb.append(getQuantidade());
        sb.append(", Preço unitário: ");
        sb.append(nf.format(getPrecoVendido()));
        sb.append(", Subtotal: ");
        sb.append(nf.format(calculaValorPorItens()));
        sb.append("\n");
        return sb.toString();
    }
}