package com.codegym.restful.service;


import com.codegym.restful.entity.Blog;
import com.codegym.restful.repository.BlogRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepositoryJpa blogRepositoty;

    @Override
    public void create(Blog blog) {
        blogRepositoty.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepositoty.save(blog);
    }

    @Override
    public void delete(String id) {
        blogRepositoty.delete(findById(id));
    }

    @Override
    public List<Blog> findAll() {
        return blogRepositoty.findAll();
    }

    @Override
    public Blog findById(String id) {
        return blogRepositoty.findById(Integer.parseInt(id)).orElse(null);
    }

    @Override
    public List<Blog> findAllByTitleContains(String search) {
        return blogRepositoty.findAllByTitleContaining(search);
    }


}
