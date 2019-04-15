package com.example.springbootapp.proj1;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class productAddController {

    @Autowired
    orderitemsRepo orderrepo;

    List<String> itemArrray = new ArrayList<>();

    @RequestMapping(value = "/enquiryPlace", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("enquiryAdd", "enquiryplace", new enquiryPlace());
    }
    


    @RequestMapping(value = "/addOrders", method = RequestMethod.POST)
    public String submitdetails(@Valid @ModelAttribute("enquiryplace")enquiryPlace enquiryplace, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
       
            return "error";
        }   
   
       
        itemArrray.add(enquiryplace.getProduct()); 
        orderitems ord = new orderitems();
        
        ord.setProduct_name(enquiryplace.getProduct());
        ord.setProduct_quantity(enquiryplace.getQuantity());
        orderrepo.save(ord);
       
       
        
        

        return "index";
    }



}