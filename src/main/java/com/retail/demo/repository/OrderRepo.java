package com.retail.demo.repository;

import com.retail.demo.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity,Long> {
}
