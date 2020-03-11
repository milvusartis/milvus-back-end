package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue
    @Column(name = "id_endereco")
    private Long id;
    @NotNull
    @Column(name = "ds_cep")
    private String cep;
    @NotNull
    @Column(name = "ds_rua")
    private String rua;
    @Column(name = "nr_imovel")
    private Integer numero;
    @Column(name = "ds_complemento")
    private String complemento;
    @NotNull
    @Column(name = "ds_bairro")
    private String bairro;
    @NotNull
    @Column(name = "ds_cidade")
    private String cidade;
    @NotNull
    @Column(name = "sg_estado")
    private String estado;
}
