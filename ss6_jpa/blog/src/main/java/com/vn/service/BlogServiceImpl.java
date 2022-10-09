package com.vn.service;

import com.vn.entity.Blog;
import com.vn.entity.Theme;
import com.vn.repository.BlogRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements  BlogService{

    private BlogRepositoty blogRepositoty;
    @Autowired
    public BlogServiceImpl(  BlogRepositoty blogRepositoty){
        this.blogRepositoty = blogRepositoty;
    }


    @Override
    public void create(Blog blog) {
        blogRepositoty.create(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepositoty.update( blog);
    }

    @Override
    public void delete(String id) {
        blogRepositoty.delete(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepositoty.findAll();
    }

    @Override
    public Blog findById(String id) {
        return blogRepositoty.findById(id);
    }

    @Override
    public List<Theme> getAllTheme() {
        return blogRepositoty.getAllTheme();
    }
}
