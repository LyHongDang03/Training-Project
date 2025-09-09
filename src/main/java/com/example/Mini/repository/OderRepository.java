package com.example.Mini.repository;

import com.example.Mini.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByDataContaining(String productName);
}
