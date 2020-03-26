package br.com.milvusartis.ecommerce.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_estoque")
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Long idEstoque;

    @Column(name = "nr_quantidade_estocada")
    private Integer qtEstoque;

    @Column(name = "nr_quantidade_reservada")
    private Integer qtReserva;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name="id_produto")
    private Produto produto;

}