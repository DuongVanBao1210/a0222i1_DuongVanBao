package com.example.quanlysanpham.restcontroller;

import antlr.collections.List;
import com.example.quanlysanpham.entity.Product;
import com.example.quanlysanpham.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shopping/cart")
public class RestCartController {

    @Autowired
    ProductService service;

//    @GetMapping("/api/shopping/show")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Product> getProductsgetStudentById() {
//
//        return studentRepository.getList();
//    }
}
