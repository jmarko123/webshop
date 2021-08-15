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

    @RequestMapping(value = "/edit-buyer")
    public String editBuyer (Model model){
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);
        return "edit-buyer";
    }

    @RequestMapping(value = "/editbuyer", method = RequestMethod.POST)
    public String editBuyer (@ModelAttribute("buyer")Buyer buyer){
        buyerService.save(buyer);
        return "redirect:/buyers";
    }

    @RequestMapping (value = "/delete-buyer")
    public String deleteBuyer (Model model){
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);
        return "delete-buyer";
    }

    @RequestMapping(value = "/deletebuyer", method = RequestMethod.POST)
    public String deleteBuyer (@ModelAttribute("buyer")Buyer buyer){
        buyerService.delete(buyer);
        return "redirect:/buyers";
    }
}
