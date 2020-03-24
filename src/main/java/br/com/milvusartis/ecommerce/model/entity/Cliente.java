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
    private Long idCliente;

    @Column(name="nm_cliente")
    private String nome;

    @Column(name="ds_cpf")
    private String cpf;

    @Column(name="ds_telefone")
    private String telefone;

    @Column(name="ds_email")
    private String email;

    @Column(name="ds_senha")
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_endereco")
    //private Long enderecoIdEndereco;
    private Endereco endereco;

}