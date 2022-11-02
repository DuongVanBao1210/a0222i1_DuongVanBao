package com.example.quanlysanpham.entity;


import org.hibernate.annotations.Entity;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {


    private List<Product> products ;

    public  void addProduct(Product product){
        this.products.add(product);
    }

    public Cart() {
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Cart(List<Product> products) {
        this.products = products;
    }
}
