package com.retail.demo.repository;

import com.retail.demo.entity.ProductEntity;
import com.retail.demo.service.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {
}
