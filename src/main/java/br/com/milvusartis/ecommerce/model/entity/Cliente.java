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
@Table(name="tb_cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long id;

    @Column(name="ds_cpf")
    private String cpf;

    @Column(name="ds_rg")
    private String rg;


    @Column(name="ds_telefone")
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id", referencedColumnName = "id_endereco")
    private Endereco endereco;

}