package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_nota_fiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue
    @Column(name ="id_nota_fiscal")
    private Long id;
    @NotNull
    @Column(name = "dt_emissao")
    private LocalDate data;
    @NotNull
    @Column(name ="id_cliente")
    private Long idCliente;
    @NotNull
    @Column(name ="id_empresa")
    private Long idEmpresa;
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
