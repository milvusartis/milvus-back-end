package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tb_empresa")
public class Empresa {
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
    @Column(name ="id_endereco")
    private Long endereco;
}
