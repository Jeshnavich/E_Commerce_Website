package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Product;
import com.example.demo.serviceimpl.ProductServiceImpl;


@Controller
public class ProductController {


    @Autowired
    ProductServiceImpl service;


    // Show all products
    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("products",
                service.getAllProducts());

        return "products";
    }


    // Show products by category
    @GetMapping("/products/category/{category}")
    public String productsByCategory(
            @PathVariable String category,
            Model model) {


        model.addAttribute("products",
                service.getProductsByCategory(category));


        model.addAttribute("category", category);


        return "products";
    }



    // Save Product
    @PostMapping("/add-product")
    public String addproduct(Product product) {

        service.addProduct(product);

        return "redirect:/products";
    }



    // Add Product Page
    @GetMapping("/add-product")
    public String addproductpage() {

        return "add-product";
    }

}