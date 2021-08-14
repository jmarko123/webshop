package com.example.webshop.controller;


import com.example.webshop.model.Buyer;
import com.example.webshop.service.impl.BuyerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuyerController {

    @Autowired
    private BuyerServiceImpl buyerService;


    @GetMapping("/buyers")
    public String getBuyers (Model model){
        model.addAttribute("buyers", buyerService.findAll());
        return "buyers";
    }

    @RequestMapping(value = "/new-buyer")
    public String newBuyer (Model model){
        Buyer buyer = new Buyer();
        model.addAttribute("buyer",buyer);
        return "new-buyer";
    }

    @RequestMapping(value = "/savebuyer", method = RequestMethod.POST)
    public String saveBuyer (@ModelAttribute("buyer")Buyer buyer){
        buyerService.save(buyer);
        return "redirect:/buyers";
    }
}
