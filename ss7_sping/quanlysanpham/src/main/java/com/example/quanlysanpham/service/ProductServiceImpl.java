package com.example.quanlysanpham.service;


import com.example.quanlysanpham.entity.ClassName;
import com.example.quanlysanpham.entity.Product;
import com.example.quanlysanpham.repository.ClassNameRepositoey;
import com.example.quanlysanpham.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {
    private IProductRepository productRepository;
    private ClassNameRepositoey classNameRepositoey;
    @Autowired

    public ProductServiceImpl(IProductRepository productRepository, ClassNameRepositoey classNameRepositoey) {
        this.productRepository = productRepository;
        this.classNameRepositoey = classNameRepositoey;
    }


    @Override
    public void create(Product product) {
        productRepository.save(product);

    }

    @Override
    public void update(Product product) {
        productRepository.save(product);

    }

    @Override
    public     void  delete( int id )
    {
        productRepository.delete(findById(id));

    }

    @Override
    public Product findById(int id) {
        return productRepository.findById( id).orElse(null);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void createClasses(ClassName className) {
        classNameRepositoey.save(className);
    }

    @Override
    public void deleteClasses(ClassName className) {
        classNameRepositoey.delete(className);
    }

    @Override
    public ClassName findByIdClasses(String id) {
            return classNameRepositoey.findById(id).orElse(null);
    }

    @Override
    public List<ClassName> getAllClasses() {

        return  classNameRepositoey.findAll();
    }
}
