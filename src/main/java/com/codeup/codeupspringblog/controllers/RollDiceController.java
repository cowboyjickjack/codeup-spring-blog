package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDicePage(){
        // return needs to be the same file name as the template (html page)
        return "rollDice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceRollOutcome(@PathVariable int n, Model model){
        double randomNumber = 1 + (int)(Math.random() * 6);
        System.out.println(randomNumber);
        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("n", n);
        return "rollDice";
    }

}
