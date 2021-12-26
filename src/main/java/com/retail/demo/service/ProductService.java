package com.retail.demo.service;



import com.retail.demo.controller.ProductResource;
import com.retail.demo.entity.ProductEntity;
import com.retail.demo.entity.UserEntity;
import com.retail.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;



    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }

    public ProductEntity create(ProductEntity productEntity) {
        return productRepo.save(productEntity); }






}
