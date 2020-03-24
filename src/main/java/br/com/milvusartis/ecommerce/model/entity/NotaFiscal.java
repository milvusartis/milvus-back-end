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
    @Column(name ="id_nf")
    private Long idNf;

    @Column(name = "dt_emissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNf;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Column(name ="ds_natureza_operacao")
    private String naturezaOperacao;

    @Column(name ="nr_nfE")
    private Integer nfE;

}