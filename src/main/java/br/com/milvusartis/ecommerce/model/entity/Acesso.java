package br.com.milvusartis.ecommerce.model.entity;

import br.com.milvusartis.ecommerce.model.tipos.Regra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_acesso")
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acesso")
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "ds_regra")
    private Regra regra;
}
