package com.example.springbootapp.proj1;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class placeOrderController {

    @Autowired
    enquiryRepo enqrepo;

    List<Integer> newlist = new ArrayList<>();

    private HttpHeaders createHttpHeaders(String user, String password)
{
    String notEncoded = user + ":" + password;
    String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("Authorization", "Basic " + encodedAuth);
    return headers;
}

private void doYourThing() 
{
    String theUrl = "https://eirls-mm.herokuapp.com/api/items-complete";
    RestTemplate restTemplate = new RestTemplate();
    try {
        HttpHeaders headers = createHttpHeaders("fred","1234");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, String.class);
        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
    }
    catch (Exception eek) {
        System.out.println("** Exception: "+ eek.getMessage());
    }
}


@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
public ModelAndView showForm(ModelAndView model) {


       enquiry enq = new enquiry();
       List<enquiry> list = enqrepo.findAll();
    
       model.addObject("list", list);
       model.setViewName("placeOrder");
       
        return model;
    //   return new ModelAndView("placeOrder", "enquiryplace", new enquiryPlace());
}



@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
public String developerMethod(@RequestParam("orderid") int id){
        
   
       
         newlist.add(id);
     
        

        return "index";
    }


}