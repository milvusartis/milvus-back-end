package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private Long nrPedido;

    @Column(name="dt_pedido")
    private Date dtPedido;

    @Column(name="vl_frete")
    private BigDecimal vlFrete;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @Column(name="ds_status_pedido")
    private String dsStatusPedido;

    @Column(name="vl_total")
    private BigDecimal vlTotal;

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
    @JoinColumn(name="id_pedido")
    private List<PedidoItem> pedidoItemPedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getNrPedido() {
        return nrPedido;
    }

    public void setNrPedido(Long nrPedido) {
        this.nrPedido = nrPedido;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public BigDecimal getVlFrete() {
        return vlFrete;
    }

    public void setVlFrete(BigDecimal vlFrete) {
        this.vlFrete = vlFrete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDsStatusPedido() {
        return dsStatusPedido;
    }

    public void setDsStatusPedido(String dsStatusPedido) {
        this.dsStatusPedido = dsStatusPedido;
    }

    public BigDecimal getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(BigDecimal vlTotal) {
        this.vlTotal = vlTotal;
    }

    public Integer getNrCartao() {
        return nrCartao;
    }

    public void setNrCartao(Integer nrCartao) {
        this.nrCartao = nrCartao;
    }

    public String getNmCartao() {
        return nmCartao;
    }

    public void setNmCartao(String nmCartao) {
        this.nmCartao = nmCartao;
    }

    public Date getDtValidadeCartao() {
        return dtValidadeCartao;
    }

    public void setDtValidadeCartao(Date dtValidadeCartao) {
        this.dtValidadeCartao = dtValidadeCartao;
    }

    public Integer getCdSegurancaCartao() {
        return cdSegurancaCartao;
    }

    public void setCdSegurancaCartao(Integer cdSegurancaCartao) {
        this.cdSegurancaCartao = cdSegurancaCartao;
    }

    public Date getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(Date dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public List<PedidoItem> getPedidoItemPedido() {
        return pedidoItemPedido;
    }

    public void setPedidoItemPedido(List<PedidoItem> pedidoItemPedido) {
        this.pedidoItemPedido = pedidoItemPedido;
    }
}