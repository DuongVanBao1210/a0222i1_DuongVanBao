package com.example.demo.service;


import com.example.demo.entity.Blog;

import java.util.List;

//@Service("blogService")
public interface BlogService {


    void create(Blog blog);

    void update(Blog blog);

    void delete(String id);

    List<Blog> findAll();

    Blog findById(String id);

    List<Blog> getListSearch(String search);
}
