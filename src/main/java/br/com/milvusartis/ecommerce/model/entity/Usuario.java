package br.com.milvusartis.ecommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_usuario")
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "acesso_id", referencedColumnName = "id_acesso")
    private Acesso acesso;
}
