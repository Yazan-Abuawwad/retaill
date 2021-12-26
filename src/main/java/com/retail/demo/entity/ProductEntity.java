package com.retail.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Generated;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name="product")
@Data
@Entity
public class ProductEntity {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "product_id")
    private  Long productId ;

@Column(name="name")
private String name ;

@Column(name = "price")
    private Double price;


@Column(name="quantity")
    private Integer quantity;



    @ManyToMany
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    @JsonIgnoreProperties( allowSetters = true)
private List<OrderEntity> orderset;
}
