package com.example.demo.service;

import com.example.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//@Service("categoryService")
public interface CategoryService {
    void create(Category category);

    void update(Category category);

    void delete(String id);

    List<Category> getAllCategory();

    Page<Category> findAllPage(Pageable pageable);


}
