package com.vn.service;

import com.vn.entity.Blog;
import com.vn.entity.Theme;

import java.util.List;

public interface BlogService {


    void create(Blog blog);
    void update(Blog blog);
    void delete(String id);
    List<Blog> findAll();
    Blog findById(String id);

    List<Theme> getAllTheme();
}
