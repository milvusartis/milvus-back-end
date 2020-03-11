package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

    @NotNull
    @Column(name="nr_pedido")
    private Integer nrPedido;

    @NotNull
    @Column(name="dt_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPedido;

    @NotNull
    @Column(name="vl_frete")
    private BigDecimal vlFrete;

    //@JoinColumn(name="id_cliente")

    @NotNull
    @Column(name="ds_status_pedido")
    private String dsStatusPedido;

    @NotNull
    @Column(name="vl_total")
    private BigDecimal vlTotal;

}
