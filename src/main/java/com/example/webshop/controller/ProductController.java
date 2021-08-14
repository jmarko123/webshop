package com.example.webshop.controller;

import com.example.webshop.model.Product;
import com.example.webshop.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;



    @GetMapping("/product-list")
    public String getProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @RequestMapping (value = "/new-product")
    public String newProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new-product";
    }

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product")Product product)
    {
        productService.save(product);
        return "redirect:/product-list";
    }


    @RequestMapping (value = "/edit-product")
    public String editProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "edit-product";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProduct (@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/product-list";

    }

    @RequestMapping (value = "/delete-product")
    public String deleteProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "delete-product";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteProduct (@ModelAttribute("product") Product product){
        productService.delete(product);
        return "redirect:/product-list";

    }



    //Nova metoda za redirekt na new-product.html
    //forma za podatke kao u Produkt modelu
    //Na new-produkt stranici da napravis dugme koje ce da submit na servis i da redirektujes na product-list stranu

}
