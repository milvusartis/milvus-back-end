package br.com.milvusartis.ecommerce.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tb_empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_empresa")
    private Long idEmpresa;

    @Column(name ="ds_razao_social")
    private String razaoSocial;

    @Column(name ="ds_cnpj")
    private String cnpj;

    @Column(name ="ds_inscricao_estadual")
    private String inscricaoEstadual;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany
    @JsonBackReference
    @JoinColumn(name="id_nf")
    private List<NotaFiscal> notasFiscais;

}