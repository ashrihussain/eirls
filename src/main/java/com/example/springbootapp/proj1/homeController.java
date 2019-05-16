package com.example.springbootapp.proj1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class homeController {

    @ResponseBody
    @GetMapping("/homesu")
    public String Hello(){
        return "It's working ashriii";
    }


    @RequestMapping("/welcome")
    public String Welcome(){
        return "welcome page";
    }


    @Value("${welcome.message}")
    private String message = "Hello World";

    @RequestMapping("/home")
    public String index() {
  
        return "index";
    }
}
