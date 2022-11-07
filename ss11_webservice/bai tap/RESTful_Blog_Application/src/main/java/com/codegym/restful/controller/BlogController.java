package com.codegym.restful.controller;

import com.codegym.restful.entity.Blog;
import com.codegym.restful.service.BlogService;
import com.codegym.restful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/home")
    public String showHome(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        model.addAttribute("cate", categoryService.getAllCategory());
        return "blog";
    }

    //create
    @GetMapping("/create")
    public String showFormCrate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("themes", categoryService.getAllCategory());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "blog") Blog blog, Model model) {
        blogService.create(blog);
        return "redirect:/blogs/home";
    }


    @GetMapping("/detail")
    public String showDetail(@RequestParam(value = "id") String id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("themes", categoryService.getAllCategory());
        return "update";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(value = "blog") Blog blog) {
        blogService.update(blog);
        return "redirect:/blogs/home";
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "search") String search, Model model) {

        List<Blog> blogs = blogService.findAllByTitleContains(search);
        model.addAttribute("blogs", blogs);
        model.addAttribute("search", search);
        return "blog";
    }

}
