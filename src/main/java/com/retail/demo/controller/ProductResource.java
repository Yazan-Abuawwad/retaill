package com.retail.demo.controller;


import com.retail.demo.entity.ProductEntity;
import com.retail.demo.entity.UserEntity;
import com.retail.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;



    @GetMapping("/products")
    // @EmployeeSecurity
    public List<ProductEntity> getAllProducts() {

        return productService.getAllProducts();
    }


    @PostMapping("/product")
    public ProductEntity createUser(@RequestBody ProductEntity productEntity) throws URISyntaxException {


        ProductEntity result = productService.create(productEntity);
        return result;
    }



}
