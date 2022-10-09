package com.vn.controller;


import com.vn.entity.Blog;
import com.vn.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService service;


    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("blogs", service.findAll());
//        model.addAttribute("themes", service.getAllTheme());
        return "home";
    }

    @GetMapping("/create")
    public String showFormCrate(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("themes", service.getAllTheme());
        return "create";
    }

    @PostMapping("/create")
    public  String create(@ModelAttribute(value = "blog") Blog blog, Model model){
        service.create(blog);
        return "redirect:/blogs/home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") String id ){

        service.delete(id);
        return "redirect:/blogs/home";
    }

    @GetMapping("/detail")
    public  String showDetail(@RequestParam(value = "id") String id, Model model){
        Blog blog = service.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("themes", service.getAllTheme());
        return "update";
    }

    @PostMapping("/edit")
    public  String edit(@ModelAttribute(value = "blog") Blog blog){
        service.update(blog);
        return "redirect:/blogs/home";
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "search") String search, Model model){

        List<Blog> list = service.findAll();
        List<Blog> blogs = new ArrayList<>();
        for ( Blog l: list ) {
            if(  l.getTitle().contains( search.trim()  ) ){
                blogs.add(l);
            }

        }
        model.addAttribute("blogs",blogs );
        model.addAttribute("search",search );
        return "home";
    }
}
