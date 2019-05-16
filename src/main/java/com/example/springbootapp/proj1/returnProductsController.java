package com.example.springbootapp.proj1;

import java.text.ParseException;
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
public class returnProductsController{

    @Autowired
    orderitemsRepo ordrep;

    @Autowired
    enquiryRepo enqrepo;

    @RequestMapping(value = "/returnItems", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("returnItemsOne", "enquiryplace", new enquiryPlace());


    }


    

        @RequestMapping(value = "/returns", method = RequestMethod.POST)
        public String submitdetails(@Valid @ModelAttribute("enquiryplace") enquiryPlace enquiryplace, 
          BindingResult result, ModelMap model) {
            if (result.hasErrors()) {
           
                return "error";
            }   

            int getid = enquiryplace.getOrderid();
       
            List<orderitems> orderlist = ordrep.findAll();
            
            for (orderitems var : orderlist) {

                if(enquiryplace.getOrderid() == var.getEnq().getOrder_id()){

                    if(enquiryplace.getId() == var.getOrderitems_id()){

                        ordrep.updateStatus(enquiryplace.getReturntype(), enquiryplace.getId());

                        
                    }


                }
                
            }

           
            
        
            
           
 
       

        return "index";
    }

}
