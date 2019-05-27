package com.example.springbootapp.proj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    orderitemsRepo ordrepo;


    
    
    @RequestMapping(value = "/registerClient", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("registerClient", "clientmodel", new clientModel());
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
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

   
    @ModelAttribute("userList")
    public Map<String, String> getUserList() {
    
      
      Map<String, String> userList = new HashMap<String, String>();
     
     List<clients> ilist = userrepo.findAll();
    
     for (clients var : ilist) {

        userList.put(String.valueOf(var.getClient_id()), String.valueOf(var.getClient_id()));
       
     }

   return userList;
}

    @RequestMapping(value = "/manageAccount", method = RequestMethod.GET)
    public ModelAndView Maccount() {
        return new ModelAndView("manageAccount", "clientmodel", new clientModel());


    }

    @RequestMapping(value = "/changeClient", method = RequestMethod.POST)
    public String submitDetails(@Valid @ModelAttribute("clientmodel")clientModel clientmodel, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        if(clientmodel.getName().isEmpty()){

          

        }else{
            userrepo.updateName(clientmodel.getName(), Integer.parseInt(clientmodel.getId()));
        }




        if(clientmodel.getAge() != 0){

            userrepo.updateAge(clientmodel.getAge(), Integer.parseInt(clientmodel.getId()));

        }

        

        if(clientmodel.getAddress().isEmpty()){

           

        }else{
            userrepo.updateAddress(clientmodel.getAddress(), Integer.parseInt(clientmodel.getId()));
        }




        if(clientmodel.getTradingname().isEmpty()){

          

        } else {

            userrepo.updateTrading(clientmodel.getTradingname(), Integer.parseInt(clientmodel.getId()));
        }


        
        if(clientmodel.getContact().isEmpty()){

          

        } else {

            userrepo.updateContact(clientmodel.getContact(), Integer.parseInt(clientmodel.getId()));
        }
        


        if(clientmodel.getStatus().isEmpty()){

          
        }else{

            userrepo.updateCredit(clientmodel.getStatus(), Integer.parseInt(clientmodel.getId()));

        }








        return "index";
    }


    @RequestMapping(value = "/clientHistory", method = RequestMethod.GET)
    public ModelAndView historyForm() {
        return new ModelAndView("clientHistory", "clientmodel", new clientModel());
    }


    @RequestMapping(value = "/clientShowHistory", method = RequestMethod.POST)
    public ModelAndView showHistory(@Valid @ModelAttribute("clientmodel")clientModel clientmodel, 
      BindingResult result, ModelMap models, ModelAndView model) {
      
        int results = Integer.parseInt(clientmodel.getId());
       
        List<orderitems> list = ordrepo.getClientdetails(results);
        model.addObject("list", list);
        model.setViewName("clientHistoryView");

        return model;
      

          
       

       
    }

}