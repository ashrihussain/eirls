package com.example.springbootapp.proj1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class enquiryController {

    @Autowired
    itemRepo itemrepo;

    @Autowired
    userRepo userrepo;

    @RequestMapping("/place")
    public String index(Model model2 ) {
        model2.addAttribute("message", userrepo.client_name());
        return "enquiryView";
    }
    
    @RequestMapping(value = "/addEnquiry", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("enquiryplace")enquiryPlace enquiryplace, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", enquiryplace.getName());
        model.addAttribute("contactNumber", enquiryplace.getProduct());
        model.addAttribute("id", enquiryplace.getQuantity());
        return "enquiryView";
    }


    

//     @RequestMapping(value="enq", method= RequestMethod.POST)
// public void placeEnq(User user){
// //user object will automatically be populated with values sent from browser or jsp page. Provide your authentication logic here
// } 

    
}