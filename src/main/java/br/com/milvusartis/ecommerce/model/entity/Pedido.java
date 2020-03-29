package br.com.milvusartis.ecommerce.model.entity;

import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    private Long id;

    @Column(name="nr_pedido")
    private Long numero;

//    @Temporal(TemporalType.DATE)
    @Column(name="dt_data_pedido")
    private Date dataPedido;

    @Column(name="vl_frete")
    private Double valorFrete;

    @Column(name="vl_total_pedido")
    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name="cd_status_pedido")
    private StatusPedido statusPedido;

    @Column(name="dt_entrega")
    private Date dataEntrega;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="item_pedido_id", referencedColumnName = "id_item_pedido")
    private List<PedidoItem> pedidoItens;

    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pagamento_id", referencedColumnName = "id_pagamento")
    private Pagamento pagamento;

    public void adicionarItem(PedidoItem item) {
        if(pedidoItens == null)
            pedidoItens = new ArrayList<>();
        pedidoItens.add(item);
    }
    public Double total() {
        Double soma = 0.00;
        for(PedidoItem item: pedidoItens)
            soma += item.calculaValorPorItens();
        return soma;
    }

}