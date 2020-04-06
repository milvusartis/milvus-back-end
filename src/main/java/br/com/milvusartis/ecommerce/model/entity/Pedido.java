package br.com.milvusartis.ecommerce.model.entity;

import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;


    @Column(name = "nr_pedido")
    private Integer numero;

    //TODO JASON DATE FORMAT
//    @Temporal(TemporalType.DATE)
    @Column(name = "dt_data_pedido")
    private LocalDate dataPedido;

    @Column(name = "vl_frete")
    private Double valorFrete;

    @Column(name = "vl_total_pedido")
    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "cd_status_pedido")
    private StatusPedido statusPedido;

    //TODO JASON DATE FORMAT
//    @Temporal(TemporalType.DATE)
    @Column(name = "dt_entrega")
    private LocalDate dataEntrega;

    @Column(name = "vl_dias_entrega")
    private Integer diasParaEntrega;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id_pedido")
    private List<PedidoItem> pedidoItens;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id_pagamento")
    private Pagamento pagamento;

    public void adicionarItem(PedidoItem item) {
        if(pedidoItens == null)
            pedidoItens = new ArrayList<>();
        pedidoItens.add(item);
    }

    @Transient
    public Double getSubtotal(){
        return calculaSubtotalValorTotalDosItensDePedido();
    }

    @Transient
    private Double calculaSubtotalValorTotalDosItensDePedido() {
        Double soma = 0.00;
        for(PedidoItem item: pedidoItens)
            soma += item.calculaValorPorItens();
        return soma;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final StringBuilder sb = new StringBuilder();
        sb.append("Pedido número: ");
        sb.append(getIdPedido());
        sb.append(", Data do Pedido: ");
        sb.append(getDataPedido().format(formatadorBarra));
        sb.append(", Cliente: ");
        sb.append(getCliente().getUsuario().getNome());
        sb.append(", Situação do Pagamento: ");
        sb.append(getPagamento().getStatusPagamento().name());
        sb.append("\nDetalhes:\n");
        for (PedidoItem pi : getPedidoItens()){
            sb.append(pi.toString());
        }
        sb.append("Frete: ");
        sb.append(nf.format(getValorFrete()));
        sb.append("\n");
        sb.append("Valor Total: ");
        sb.append(nf.format(getValorTotal()));

        return sb.toString();
    }
}