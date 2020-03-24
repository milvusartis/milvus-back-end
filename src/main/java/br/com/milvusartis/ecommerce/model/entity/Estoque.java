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
@Table(name = "tb_estoque")
public class Estoque implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Long idEstoque;
    @Column(name = "nr_quantidade_estocado")
    private Integer quantidadeEstoque;
    @Column(name = "nr_qauntidade_reservado")
    private Integer quantidadeReservada;


}
