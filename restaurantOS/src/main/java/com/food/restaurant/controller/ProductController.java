package com.food.restaurant.controller;

import com.food.restaurant.model.Product;
import com.food.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public String getProductlist(Model model){
        model.addAttribute("products",productService.getAll());
        return "product";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product-add";
    }


    @PostMapping("/products/save")
    public String saveProduct(Product product, Model model){

        productService.saveProduct(product);

        model.addAttribute("products", productService.getAll());

        return "product";
    }

    @GetMapping("/products/edit/{id}")
    public String getProductForEdit(@PathVariable Integer id,
                                    Model model){
        model.addAttribute("product",
                productService.findById(id));
        return "product-edit";
    }

    @PostMapping("/products/update/{id}")
    public String updateProduct(@PathVariable Integer id,
                                 Product product,
                                 Model model){
        productService.updateProduct(id, product);
        model.addAttribute("products",
                productService.getAll());
        return "product";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id,
                                 Model model){
        productService.deleteProduct(id);
        model.addAttribute("products",
                productService.getAll());
        return "product";
    }
}

