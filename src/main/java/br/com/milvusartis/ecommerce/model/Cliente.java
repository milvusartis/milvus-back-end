package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

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

    @NotNull
    @Column(name="nm_cliente")
    private String nmCliente;

    @NotNull
    @Column(name="ds_cpf")
    private String dsCpf;

    @NotNull
    @Column(name="ds_telefone")
    private String dsTelefone;

    @NotNull
    @Column(name="ds_email")
    private String dsEmail;

    @NotNull
    @Column(name="ds_senha")
    private String dsSenha;

    @NotNull
    @Column(name="id_endereco")
    private Endereco endereco;


    @OneToMany
    @JoinColumn(name="cliente")
    private List<Pedido> pedidoCliente;

//    @OneToMany
//    @JoinColumn(name="cliente")
//    private List<NotaFiscal> notaFiscalCliente;



    //na tabela endereço:
    //@OneToOne
    //@JoinColumn(name = "id_endereco")
    //private List<Cliente> clienteEndereco;

}
