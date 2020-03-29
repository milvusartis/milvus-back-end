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
@Table(name="tb_pagamento")
public class Pagamento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pagamento")
    private Long id;

    @Column(name="ds_titular_pagamento")
    private String titularPagamento;

    @Column(name="ds_telefone_titular")
    private String telefoneTitular;

    @Column(name="ds_cpf_titular")
    private String cpfTitular;

    @Column(name="ds_forma_pagamento")
    private String formaPagamento;

    @Column(name="cd_aprovado")
    private Boolean isAprovado;


}






