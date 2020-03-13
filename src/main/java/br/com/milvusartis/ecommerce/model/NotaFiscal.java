package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_nota_fiscal")
public class NotaFiscal implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="id_nf")
    private Long idNf;
    @Column(name = "dt_emissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    //@Column(name ="id_cliente")
    //private Long idCliente;
    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;
    @OneToOne(cascade = CascadeType.ALL)
    private Pedido pedido;
    //@Column(name ="id_pedido")
    //private Long idPedido;
    @Column(name ="ds_natureza_operacao")
    private String naturezaOperacao;
    @Column(name ="nr_nfe")
    private Integer nfe;
}
