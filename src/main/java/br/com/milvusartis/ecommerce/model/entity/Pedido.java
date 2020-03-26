package br.com.milvusartis.ecommerce.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Long idPedido;

    @Column(name="nr_pedido")
    private Long numero;

    @Column(name="dt_pedido")
    private Date dtPedido;

    @Column(name="vl_frete")
    private Double vlFrete;

    @Column(name="ds_status_pedido")
    private String statusPedido;

    @Column(name="vl_total")
    private Double vlTotal;

    @Column(name="nr_cartao")
    private Integer nrCartao;

    @Column(name="nm_cartao")
    private String nmCartao;

    @Column(name="dt_validade_cartao")
    private Date dtValidadeCartao;

    @Column(name="cd_seguranca_cartao")
    private Integer cdSegurancaCartao;

    @Column(name="dt_entrega")
    private Date dtEntrega;

    @OneToMany(cascade=CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name="id_pedido")
    private List<PedidoItem> pedidoItens;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name="id_nf")
    private NotaFiscal notaFiscal;

//    public void adicionarItem(PedidoItem item) {
//        if(pedidoItens == null)
//            pedidoItens = new ArrayList<>();
//        pedidoItens.add(item);
//    }
//    public Double total() {
//        Double soma = 0.00;
//        for(PedidoItem i: pedidoItens)
//            soma += i.calc();
//        return soma;
//    }

}