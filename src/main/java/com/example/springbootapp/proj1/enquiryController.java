package com.example.springbootapp.proj1;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class enquiryController {

   // List<Integer> quantityArray = new ArrayList<>();
    List<String> itemArrray = new ArrayList<>();

  //  int i = itemArrray.size();
    
    

    @Autowired
    itemRepo itemrepo;

    @Autowired
    userRepo userrepo;

    @Autowired
    enquiryRepo enqrepo;

    @Autowired
    orderitemsRepo orderrepo;

    @RequestMapping(value = "/enquiry", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("enquiryView", "enquiryplace", new enquiryPlace());
    }
    
    @RequestMapping(value = "/addEnquiry", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("enquiryplace")enquiryPlace enquiryplace, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        String s = "pending";
        int index =0;
        enquiry enq = new enquiry();
        enq.setClient_name(enquiryplace.getName());
        enq.setDue_date(enquiryplace.getDate());
        enq.setOrder_status(s);
        enquiry e =  enqrepo.save(enq);

        for (String productname : itemArrray) {
            
                orderrepo.updateItem(e.getOrder_id(), productname);
                }   
        
        itemArrray.clear();

        return "index";
    }

    @RequestMapping(value = "/enquiryAdd", method = RequestMethod.GET)
    public ModelAndView showForm2() {
        return new ModelAndView("enquiryAddProduct", "enquiryitemplace", new enquiryItemPlace());
    }
    


    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String submititem(@Valid @ModelAttribute("enquiryitemplace")enquiryItemPlace enquiryitemplace, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }   
   
       
        itemArrray.add(enquiryitemplace.getProductname()); 
        orderitems ord = new orderitems();
        
        ord.setProduct_name(enquiryitemplace.getProductname());
        ord.setProduct_quantity(enquiryitemplace.getQuantity());
        orderrepo.save(ord);
       
       
        
        

        return "index";
    }


    

//     @RequestMapping(value="enq", method= RequestMethod.POST)
// public void placeEnq(User user){
// //user object will automatically be populated with values sent from browser or jsp page. Provide your authentication logic here
// } 

    
}