package br.com.milvusartis.ecommerce.model.entity;

import br.com.milvusartis.ecommerce.model.tipos.Regra;
import br.com.milvusartis.ecommerce.model.tipos.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long idPagamento;

    @Column(name = "ds_titular_pagamento")
    private String titularPagamento;

    @Column(name = "ds_telefone_titular")
    private String telefoneTitular;

    @Column(name = "ds_cpf_titular")
    private String cpfTitular;

    @Column(name = "ds_forma_pagamento")
    private String formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_status_pagamento")
    private StatusPagamento statusPagamento;


}






