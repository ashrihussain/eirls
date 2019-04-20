package com.example.springbootapp.proj1;

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
public class registerClientController {


    @Autowired
    userRepo userrepo;
    
    
    @RequestMapping(value = "/registerClient", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("registerClient", "clientmodel", new clientModel());
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("clientmodel")clientModel clientmodel, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }


       clients client = new clients();
       client.setClient_name(clientmodel.getName());
       client.setClient_trade(clientmodel.getTradingname());
       client.setClient_age(clientmodel.getAge());
       client.setClient_address(clientmodel.getAddress());
       client.setClient_contact(clientmodel.getContact());
       client.setClient_status(clientmodel.getStatus());

       userrepo.save(client);



        return "index";
    }

}