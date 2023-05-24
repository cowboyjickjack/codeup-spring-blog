package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Coffee;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoffeeController {

    @GetMapping("/coffee")
    public String coffeePage(){
        return "coffee";
    }

    @PostMapping("/coffee")
    public String newsletterSignUp(@RequestParam(name = "email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }

    @GetMapping("/coffee/{roast}")
    public String favRoast(@PathVariable String roast, Model model){
        // get used to idea that Controllers turn everything into Objects
        // so normalize using objects
        Coffee coffee1 = new Coffee(roast, "", "Cool Beans");
        Coffee coffee2 = new Coffee(roast, "", "Java Beans");
        // ternary version:
        // coffee.setOrigin(roast.equals("dark") ? "Sumatra" : "Columbia");
        if (roast.equals("dark")) {
            coffee1.setOrigin("Sumatra");
            coffee2.setOrigin("Brazil");
        } else if (roast.equals("medium")){
            coffee1.setOrigin("Columbia");
            coffee2.setOrigin("Uganda");
        } else {
            coffee1.setOrigin("Chicago");
            coffee2.setOrigin("Ethiopia");
        }
        // then we make a list!
        List<Coffee> coffees = new ArrayList<>(List.of(coffee1, coffee2));
        model.addAttribute("roast", roast);
        model.addAttribute("coffees", coffees);
        return "coffee";
    }
}
