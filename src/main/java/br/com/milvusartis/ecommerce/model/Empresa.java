package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tb_empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="id_empresa")
    private Long idEmpresa;
    @Column(name ="ds_razao_social")
    private String razaoSocial;
    @Column(name ="ds_cnpj")
    private String cnpj;
    @Column(name ="ds_inscricao_estadual")
    private String inscricaoEstadual;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
