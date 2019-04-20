package com.example.springbootapp.proj1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
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

    private HttpHeaders createHttpHeaders(String user, String password) {
        String notEncoded = user + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + encodedAuth);
        return headers;
    }

    private void doYourThing() {
        String theUrl = "https://eirls-mm.herokuapp.com/api/items-complete";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = createHttpHeaders("fred", "1234");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, String.class);
            System.out.println("Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
        } catch (Exception eek) {
            System.out.println("** Exception: " + eek.getMessage());
        }
    }

    @RequestMapping(value = "/showEnquiry", method = RequestMethod.GET)
    public ModelAndView showForm(ModelAndView model) throws ParseException {

     Date now = new Date();

  //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  //  LocalDate localDate = LocalDate.now();

         Calendar calendar = Calendar.getInstance();
         calendar.setTime(now);
         int currentdate = calendar.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();
        int currentmonth = date.getMonth();

         enquiry enq = new enquiry();
         List<enquiry> list = enqrepo.findPending();

        for (enquiry e : list) {

            Date date1 = e.getDate_placed();  
          int placedmonth = date1.getMonth();
             Calendar c2 = Calendar.getInstance();
             c2.setTime(date1);
             int placeddate = c2.get(Calendar.DAY_OF_MONTH);


           

            if(currentdate > placeddate){

                enqrepo.deleteItem(e.getOrder_id());

                
            } 

            if(currentmonth > placedmonth){
                
                enqrepo.deleteItem(e.getOrder_id());

            }

        
            
        }

       model.addObject("list", list);
       model.setViewName("placeOrder");
       
        return model;
   
}



@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
public String developerMethod(@RequestParam("myField") int id){
        
   
       
         newlist.add(id);

         enqrepo.updateItem("confirmed", id);
        

         return "redirect:/showEnquiry";
    }


    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
public String developerMethodcancel(@RequestParam("myField") int id){
        
      enqrepo.deleteItem(id);

      

      return "redirect:/showOrder";
        

    }

    @RequestMapping(value = "/showOrder", method = RequestMethod.GET)
    public ModelAndView showForm2(ModelAndView model) throws ParseException {


         enquiry enq = new enquiry();
         List<enquiry> list = enqrepo.findConfirmed();


       model.addObject("list", list);
       model.setViewName("showOrder");
       
        return model;
}


}