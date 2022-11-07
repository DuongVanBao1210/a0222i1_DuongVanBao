package com.codegym.restful.restRepo;

import com.codegym.restful.entity.Blog;
import com.codegym.restful.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestBlogController {


    @Autowired
    BlogService blogService;

    @GetMapping("/api/blog/searchTitle")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getListSearch(@RequestParam("searchTitle") String  searchTitle){
        return  blogService.findAllByTitleContains(searchTitle);
    }


    @DeleteMapping("/api/blog/delete")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> delete(@RequestParam("idDelete") String idDelete){
        blogService.delete(idDelete);
         return  blogService.findAll();
    }

}
