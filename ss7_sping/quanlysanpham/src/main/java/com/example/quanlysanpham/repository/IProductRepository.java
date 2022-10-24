package com.example.quanlysanpham.repository;

import com.example.quanlysanpham.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
