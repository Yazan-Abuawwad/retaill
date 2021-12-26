package com.retail.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name="my_order")
@Data
@Entity
public class OrderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private  Long orderId ;


    @Column(name = "time")
    private LocalDateTime  time ;


    @Column(name = "amountBill")
    private Double amountBill;

    @Column(name = "discountBill")
    private Double discountBill;

    @Column(name = "totalAmountBill")
    private Double totalAmountBill;







    @ManyToOne(  fetch = FetchType.LAZY)
    @JsonIgnoreProperties( allowSetters = true)
     @NotNull
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
private UserEntity userEntity;



@ManyToMany(mappedBy = "orderset", fetch = FetchType.LAZY)
@JsonIgnoreProperties( allowSetters = true)
private List<ProductEntity> productEntitySet;






}
