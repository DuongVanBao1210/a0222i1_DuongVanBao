package com.example.demo.service;


import com.example.demo.entity.Blog;
import com.example.demo.repository.BlogRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//@Service("blogService")
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepositoryJpa blogRepositoty;
//    @Autowired
////    public BlogServiceImpl(  BlogRepositoryJpa blogRepositoty){
//        this.blogRepositoty = blogRepositoty;
//    }


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
    public List<Blog> getListSearch(String search) {
        return blogRepositoty.findAllByTitleContaining(search);
    }


}
