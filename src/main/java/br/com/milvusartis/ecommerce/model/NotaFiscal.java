package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_nota_fiscal")
public class NotaFiscal implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="id_nf")
    private Long idNf;
    @NotNull
    @Column(name = "dt_emissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @NotNull
    @Column(name ="id_cliente")
    private Long idCliente;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empresa",referencedColumnName = "id_empresa")
    private Empresa empresa;
    @NotNull
    @Column(name ="id_pedido")
    private Long idPedido;
    @NotNull
    @Column(name ="ds_natureza_operacao")
    private String naturezaOperacao;
    @NotNull
    @Column(name ="nr_nfe")
    private Integer nfe;

}
