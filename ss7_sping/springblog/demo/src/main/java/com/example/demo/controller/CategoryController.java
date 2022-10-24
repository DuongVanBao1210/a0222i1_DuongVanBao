package com.example.demo.controller;



import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
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
//    @Qualifier("categoryService")
    private CategoryService categoryService;
//    @Autowired
//    private BlogService blogService;

//    @GetMapping("/list")
//    public String getAll(Model model){
//     List<Category> categories =  categoryService.getAllCategory();
//    model.addAttribute("categories", categories );
//    return "categoryList";
//    }


    @GetMapping("/list")
    public String getAll( Model model,  @RequestParam(value = "page") Optional<Integer> page ) {
        int currentPage = page.orElse(1);
        int pageSize =  5;
        Page<Category> categories = categoryService.findAllPage( PageRequest.of(currentPage - 1, pageSize));

        int totalItems = categories.getNumberOfElements();
        int totalPages = categories.getTotalPages();


        model.addAttribute("categories", categories);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);

//        if (categories.getTotalPages() > 1) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, categories.getTotalPages())
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
        return "categoryList";
    }

    @PostMapping("/delete")
    public String deleteCate(@RequestParam(value = "idDelete") String idDelete, Model model) {

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
