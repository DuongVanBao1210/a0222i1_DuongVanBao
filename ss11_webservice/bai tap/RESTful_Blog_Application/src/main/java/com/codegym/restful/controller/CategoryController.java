package com.codegym.restful.controller;
import com.codegym.restful.entity.Category;
import com.codegym.restful.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String getAll(Model model, @RequestParam(value = "page") Optional<Integer> page ) {
        int currentPage = page.orElse(1);
        int pageSize =  5;
        Page<Category> categories = categoryService.findAllPage( PageRequest.of(currentPage - 1, pageSize));

        int totalItems = categories.getNumberOfElements();
        int totalPages = categories.getTotalPages();


        model.addAttribute("categories", categories);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        return "categoryList";
    }

    @PostMapping("/delete")
    public String deleteCatedd( @RequestParam(name = "idDelete") String idDelete) {
        categoryService.delete(idDelete);
        return "redirect:/category/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "category") Category category, Model model) {
        categoryService.create(category);
        return "redirect:/category/list";
    }


}
