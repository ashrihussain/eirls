package com.example.springbootapp.proj1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
    List<Integer> itemArrray = new ArrayList<>();

  //  int i = itemArrray.size();
    
    int saved_id;

    @Autowired
    itemRepo itemrepo;

    @Autowired
    userRepo userrepo;

    @Autowired
    enquiryRepo enqrepo;

    @Autowired
    orderitemsRepo ordrepo;

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

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	      LocalDate localDate = LocalDate.now();

        String s = "pending";
        Date now = new Date();
        LocalDateTime nows = LocalDateTime.now();

        clients c = userrepo.getclient(enquiryplace.getId());

        
       // String name = enqrepo.findCustomer(c);

        

        enquiry enq = new enquiry();
    
        enq.setCid(c);
        enq.setDate_placed(now);
        enq.setClient_name(c.getClient_name());
      
        enq.setOrder_status(s);

    //    enqrepo.updateOrder(s, now, enquiryplace.getClientname(), enquiryplace.getDate(), saved_id);
       enquiry e = enqrepo.save(enq);




        for (int var : itemArrray) {
         
          ordrepo.updateItem(e, var);
         
        }
         
        itemArrray.clear();


        if(c.getClient_status().equals("Invalid")) {

          enqrepo.delete(e);

        }
               
        
      
        
       

        return "redirect:/showEnquiry";
    }

  

    @RequestMapping(value = "/enquiryPlace", method = RequestMethod.GET)
    public ModelAndView showForm2() {
        return new ModelAndView("enquiryAdd", "enquiryplace", new enquiryPlace());
    }
    


    @RequestMapping(value = "/placeEnquiries", method = RequestMethod.POST)
    public String submitdetails(@Valid @ModelAttribute("enquiryplace") enquiryPlace enquiryplace, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
       
            return "error";
        }   
   
       String p = "Out of Stock";
        
   

        
         orderitems ord = new orderitems();
        
    //     ord.setOrder_id(e.getOrder_id());
         ord.setProduct_name(enquiryplace.getProductname());
         ord.setProduct_quantity(enquiryplace.getQuantity());
         ord.setAvailability(p);
         ord.setProduct_status("Pending");
         ord.setProduct_type(enquiryplace.getReturntype());

        orderitems o = ordrepo.save(ord);

         itemArrray.add(o.getOrderitems_id()); 
         
      //  saved_id = e.getOrder_id();
       
        
        

        return "redirect:/enquiryPlace";
    }
    

//     @RequestMapping(value="enq", method= RequestMethod.POST)
// public void placeEnq(User user){
// //user object will automatically be populated with values sent from browser or jsp page. Provide your authentication logic here
// } 

    
}