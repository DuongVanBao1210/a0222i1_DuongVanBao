package com.example.quanlysanpham.controller;


import com.example.quanlysanpham.entity.ClassName;
import com.example.quanlysanpham.entity.Product;
import com.example.quanlysanpham.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/shopping")
@SessionAttributes("productInCart")
public class CartProductController {

    @Autowired
    private ProductService productService;

//    @ModelAttribute("productInCart")
//    public List<Product> getProductCart() {
//        return new ArrayList<Product>();
//    }
////    private List<Product> productInCart =

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  1;

        Page<Product> products = productService.getAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products",products );
        int numbers = products.getNumber();
        int totalItems = products.getNumberOfElements();
        int totalPages = products.getTotalPages();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "cart/listProduct";
    }


    @GetMapping("/detail")
    public String getShopingCart ( @RequestParam("id") String id , Model model){

        Product product = productService.findById( Integer.parseInt(id));
                List<ClassName> classNames = productService.getAllClasses();
        model.addAttribute("product", product);
        model.addAttribute("classNames", classNames);
        return "cart/detail";
    }

    @PostMapping("/addCart")
    public String addCart (@RequestParam( value = "idProduct") String idProduct, Model model,
                           @CookieValue(name = "jsonString", defaultValue = "") String  jsonString,
                           HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        Product product = productService.findById( Integer.parseInt(idProduct));

        if(  jsonString == null || jsonString.trim().equals("") || jsonString.isEmpty())
             jsonString = product.getId() + "";
        else{
            List<String>  listId = Arrays.asList(  jsonString.split(","));
            if( !listId.contains( idProduct)){ // neu khong to tai moi them vo
                jsonString = product.getId() + "," + jsonString;
            }
        }
        try {
            Cookie cookie  = new Cookie( "jsonString", URLEncoder.encode( jsonString, "UTF-8" ) );
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            model.addAttribute("jsonString", cookie);
            System.out.println(jsonString);
        } catch (UnsupportedEncodingException e) {
            System.out.println("That bai");
            e.printStackTrace();
        }
        return "redirect:/shopping/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model, @CookieValue(value = "jsonString", defaultValue = "") String jsonString,
                       HttpServletResponse  response){

        if( !jsonString.isEmpty()){

        String[] listId = jsonString.split(",");
        List<Product> products = new ArrayList<Product>();


        for( String id : listId ) {
            Product p = productService.findById( Integer.parseInt(id));
            products.add(p);
        }
//        Collections.reverse(products);
        model.addAttribute("products", products);
        }
        return  "cart/cart";
    }



    @PostMapping("/addCard2")
    public String addCard2(@RequestParam( value = "idProduct") String idProduct, Model model,
                           @CookieValue(name = "jsonString", defaultValue = "") String  jsonString,
                           HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        Product product = productService.findById( Integer.parseInt(idProduct));

//        if(  jsonString == null || jsonString.trim().equals("") || jsonString.isEmpty())
//            jsonString = product.getId() + "";
//        else{
//            List<String>  listId = Arrays.asList(  jsonString.split(","));
//            if( !listId.contains( idProduct)){ // neu khong to tai moi them vo
//                jsonString = product.getId() + "," + jsonString;
//            }
//        }

        try {
//            String jsonStr = JSONArray.toJSONString(list);
            Cookie cookie  = new Cookie( "jsonString", URLEncoder.encode( jsonString, "UTF-8" ) );
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            model.addAttribute("jsonString", cookie);
            System.out.println(jsonString);
        } catch (UnsupportedEncodingException e) {
            System.out.println("That bai");
            e.printStackTrace();
        }
        return "redirect:/shopping/cart";
    }

}
