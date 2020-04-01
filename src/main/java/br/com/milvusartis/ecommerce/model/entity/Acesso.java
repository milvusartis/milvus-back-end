package br.com.milvusartis.ecommerce.model.entity;

import br.com.milvusartis.ecommerce.model.tipos.Regra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_acesso")
public class Acesso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acesso")
    private Long idAcesso;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_regra")
    private Regra regra;

}