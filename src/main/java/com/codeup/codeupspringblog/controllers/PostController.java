package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping(path = "/posts")
    @ResponseBody
    public String allPosts(Model model){
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("New Phone", "Call me!");
        Post post2 = new Post("Need New Songs", "What should I listen to?");
        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @PostMapping("/posts")
    @ResponseBody
    public String individualPost(Model model){
        Post post = new Post("Help", "I need help.");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping(path = "/index/create")
    @ResponseBody
    public String showPost(@PathVariable String title, String body, Model model){
        return "index";
    }

}
