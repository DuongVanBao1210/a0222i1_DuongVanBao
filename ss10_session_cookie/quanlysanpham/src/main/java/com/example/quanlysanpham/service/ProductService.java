package com.example.quanlysanpham.service;

import com.example.quanlysanpham.entity.ClassName;
import com.example.quanlysanpham.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    void  create(Product product);
    void  update(Product product);
    void  delete( int id );
    Product findById(int id);
    List<Product> getAll();
    Page<Product> getAll(Pageable pageable);

    void createClasses(ClassName    className);
    void deleteClasses(ClassName className);
    ClassName findByIdClasses(String id);
    List<ClassName> getAllClasses( );
}
