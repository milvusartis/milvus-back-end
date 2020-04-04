package br.com.milvusartis.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_nota_fiscal")
public class NotaFiscal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nf")
    private Long idNotaFiscal;

    @Column(name = "nr_nf")
    private Integer numeroNf;

    @Column(name = "dt_emissao")
    //TODO JASON DATE FORMAT
//    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;

    @Column(name = "ds_natureza_operacao")
    private String naturezaOperacao;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_empresa")
    private Empresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id", referencedColumnName = "pedido_fiscal")
    private Pedido pedido;

}