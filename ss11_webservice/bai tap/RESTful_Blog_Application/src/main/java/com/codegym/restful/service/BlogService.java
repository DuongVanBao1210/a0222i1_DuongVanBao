package com.codegym.restful.service;

import com.codegym.restful.entity.Blog;
import java.util.List;

public interface BlogService {


    void create(Blog blog);

    void update(Blog blog);

    void delete(String id);

    List<Blog> findAll();

    Blog findById(String id);

    List<Blog> findAllByTitleContains(String search);
}
