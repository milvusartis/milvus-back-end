package br.com.milvusartis.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(name = "ds_name")
    private String name;
    @NotNull
    @Column(name = "ds_description")
    private String description;
    @NotNull
    @Column(name = "ds_image")
    private String image;
    @NotNull
    @Column(name = "vl_price")
    private Double price;
    @NotNull
    @Column(name = "cd_availability")
    private Boolean availability;
    //    private Category category


}
