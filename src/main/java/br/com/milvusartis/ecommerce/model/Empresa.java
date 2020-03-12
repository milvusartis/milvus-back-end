package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tb_empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="id_empresa")
    private Long idEmpresa;
    @NotNull
    @Column(name ="ds_razao_social")
    private String razaoSocial;
    @NotNull
    @Column(name ="ds_cnpj")
    private String cnpj;
    @NotNull
    @Column(name ="ds_inscricao_estadual")
    private String inscricaoEstadual;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco",referencedColumnName = "id_endereco")
    private Endereco endereco;
    @OneToOne(mappedBy = "tb_nota_fiscal")
    private NotaFiscal notaFiscal;
}
