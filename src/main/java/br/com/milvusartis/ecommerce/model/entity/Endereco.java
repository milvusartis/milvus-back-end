package br.com.milvusartis.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;

    @Column(name = "ds_rua")
    private String rua;

    @Column(name = "nr_numero")
    private Integer numero;

    @Column(name = "ds_complemento")
    private String complemento;

    @Column(name = "ds_bairro")
    private String bairro;

    @Column(name = "ds_cidade")
    private String cidade;

    @Column(name = "sg_uf")
    private String uf;

    @Column(name = "cd_cep")
    private String cep;

}