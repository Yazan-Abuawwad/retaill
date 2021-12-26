package com.retail.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.retail.demo.entity.enumeration.User_Type;
import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Table(name="user")
@Data
@Entity
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private  Long userId ;



    @Column(name="name")
    private String name ;


    @Enumerated(EnumType.STRING)
    @Column(name="user_type")
    private User_Type user_type;


    @OneToMany
    @JsonIgnoreProperties( allowSetters = true)
    @JoinColumn(name = "order_id",insertable = false, updatable = false)
    @Nullable
   private List<OrderEntity> orderset;





}
