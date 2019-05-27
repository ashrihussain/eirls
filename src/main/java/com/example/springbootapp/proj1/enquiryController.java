package com.example.springbootapp.proj1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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
    public ModelAndView productAdder() {

        return new ModelAndView("enquiryAdd", "enquiryplace", new enquiryPlace());
    }
    


    @RequestMapping(value = "/placeEnquiries", method = RequestMethod.POST)
    public String submitdetails(@Valid @ModelAttribute("enquiryplace") enquiryPlace enquiryplace, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
       
            return "error";
        }   


        String theUrl = "https://eirls-mm.herokuapp.com/api/items-raw";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleHRlcm5hbCIsImlhdCI6MTU1NTMyNjk2OSwiZXhwIjoxNTU1NDEzMzY5fQ.kDnlreG8p_VcoLh3FVrZI3a8go4IXQCWHBMIGJxNOaMeKsrhPz-Axv3RWiXgsxbQNXmXc4HTx7IQ9622Z20RZw";
        RestTemplate restTemplate = new RestTemplate();


        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer " + token);

         

           
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            
            ResponseEntity<MaterialDetails[]> respEntity = restTemplate.exchange(theUrl, HttpMethod.GET, entity, MaterialDetails[].class);
            List<orderitems> orderitemslist = ordrepo.pendings();

           

           

            MaterialDetails[] resp = respEntity.getBody();
            for (MaterialDetails var : resp) {


          
                 if(var.getName().equals(enquiryplace.getProductname())){



                  if(var.getQuantity()>=enquiryplace.getQuantity()){

                 
                    
   

        
                    orderitems ord = new orderitems();
                   
                    ord.setMaterial_order_id(var.getId());
                    ord.setProduct_name(enquiryplace.getProductname());
                    ord.setProduct_quantity(enquiryplace.getQuantity());
                 
                    ord.setProduct_type("Raw Material");
                    ord.setProduct_status("Ordered");
              
           
                   orderitems o = ordrepo.save(ord);
           
                    itemArrray.add(o.getOrderitems_id()); 

                    return "redirect:/enquiryPlace";


                     }
                
                   
                }
                

             
                
            }


        } catch (Exception eek) {
            System.out.println("** Exception: " + eek.getMessage());
        }


        String theUrl2 = "https://eirls-mm.herokuapp.com/api/items-complete";
        String token2 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleHRlcm5hbCIsImlhdCI6MTU1NTMyNjk2OSwiZXhwIjoxNTU1NDEzMzY5fQ.kDnlreG8p_VcoLh3FVrZI3a8go4IXQCWHBMIGJxNOaMeKsrhPz-Axv3RWiXgsxbQNXmXc4HTx7IQ9622Z20RZw";
        RestTemplate restTemplates = new RestTemplate();


        try {
        

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer " + token2);

          

           
            HttpEntity<String> entities = new HttpEntity<String>("parameters", headers);
            
            ResponseEntity<MaterialDetails[]> respEntity2 = restTemplates.exchange(theUrl2, HttpMethod.GET, entities, MaterialDetails[].class);
            List<orderitems> orderitemslist = ordrepo.pendings();

           

           

            MaterialDetails[] resp = respEntity2.getBody();
            for (MaterialDetails var : resp) {


          
                 if(var.getName().equals(enquiryplace.getProductname())){

                  if(var.getQuantity()>=enquiryplace.getQuantity()){
                    
                 
        
   

        
                    orderitems ord = new orderitems();
                   
                    ord.setMaterial_order_id(var.getId());
                    ord.setProduct_name(enquiryplace.getProductname());
                    ord.setProduct_quantity(enquiryplace.getQuantity());
                  
                    ord.setProduct_status("Ordered");
                    ord.setProduct_type("Finished Good");
                 
           
                   orderitems o = ordrepo.save(ord);
           
                    itemArrray.add(o.getOrderitems_id()); 

                    return "redirect:/enquiryPlace";

                     }
                
                   
                }
                

             
                
            }


        } catch (Exception eek) {
            System.out.println("** Exception: " + eek.getMessage());
        }




        return "redirect:/enquiryPlaceFailed";
    }
    

//     @RequestMapping(value="enq", method= RequestMethod.POST)
// public void placeEnq(User user){
// //user object will automatically be populated with values sent from browser or jsp page. Provide your authentication logic here
// } 


@RequestMapping(value = "/enquiryPlaceFailed", method = RequestMethod.GET)
public ModelAndView productAdderfailed() {
    return new ModelAndView("enquiryFailed", "enquiryplace", new enquiryPlace());
}



@ModelAttribute("productList")
public Map<String, String> getPorductList() {

  
  Map<String, String> productList = new HashMap<String, String>();
 
 List<items> ilist = itemrepo.findAll();

 for (items var : ilist) {

  productList.put(var.getProduct_name(), var.getProduct_name());
   
 }


   return productList;
}
    
}