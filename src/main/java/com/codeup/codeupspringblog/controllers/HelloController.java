package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    // to return string, make a method
    public String hello(){
        System.out.println("here");
        return "Hello from Spring!";
    }

    // GetMapping only takes one argument
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // RequestMapping takes two arguments
    @RequestMapping(path = "/hello/{name1}/and/{name2}", method = RequestMethod.POST)
    @ResponseBody
    public String sayHelloTwo(@PathVariable String name1, @PathVariable String name2){
        return name1 + " says hello to " + name2 + "!";
    }

}
