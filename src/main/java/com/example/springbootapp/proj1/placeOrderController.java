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

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class placeOrderController {

    @Autowired
    enquiryRepo enqrepo;

    @Autowired
    orderitemsRepo ordrepo;

    @Autowired
    deliveryRepo delrepo;

    @Autowired
    courierRepo crepo;


    List<Integer> newlist = new ArrayList<>();

    private void getDetails() {
        String theUrl = "https://eirls-mm.herokuapp.com/api/items-complete";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleHRlcm5hbCIsImlhdCI6MTU1NTMyNjk2OSwiZXhwIjoxNTU1NDEzMzY5fQ.kDnlreG8p_VcoLh3FVrZI3a8go4IXQCWHBMIGJxNOaMeKsrhPz-Axv3RWiXgsxbQNXmXc4HTx7IQ9622Z20RZw";
        RestTemplate restTemplate = new RestTemplate();


        try {
            // HttpHeaders headers = createHttpHeaders("fred", "1234"); //token

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer " + token);

            // HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            // ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, String.class);

           
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            
            ResponseEntity<MaterialDetails[]> respEntity = restTemplate.exchange(theUrl, HttpMethod.GET, entity, MaterialDetails[].class);
            List<orderitems> orderitemslist = ordrepo.findAll();

           

           

            MaterialDetails[] resp = respEntity.getBody();
            for (MaterialDetails var : resp) {
                int quantity = var.getQuantity();
                for (orderitems itm : orderitemslist) {


                 if(var.getName().equals(itm.getProduct_name())){
                    itm.setMaterial_order_id(var.getId());
                    itm.setProduct_type("Finished Good");
                    
                     if(var.getQuantity() > itm.getProduct_quantity()){
                    itm.setAvailability("In Stock");
                   
                    

                    System.out.println(var.getId());
                    quantity = quantity - itm.getProduct_quantity();
                    System.out.println(quantity);
                    ordrepo.save(itm);
                     }
                }
                   
                }
                

             
                
            }



            // System.out.println("Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
            // System.out.println(response);
        } catch (Exception eek) {
            System.out.println("** Exception: " + eek.getMessage());
        }
    }

    private void getDetailsRaw() {
        String theUrl = "https://eirls-mm.herokuapp.com/api/items-raw";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleHRlcm5hbCIsImlhdCI6MTU1NTMyNjk2OSwiZXhwIjoxNTU1NDEzMzY5fQ.kDnlreG8p_VcoLh3FVrZI3a8go4IXQCWHBMIGJxNOaMeKsrhPz-Axv3RWiXgsxbQNXmXc4HTx7IQ9622Z20RZw";
        RestTemplate restTemplate = new RestTemplate();


        try {
            // HttpHeaders headers = createHttpHeaders("fred", "1234"); //token

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer " + token);

            // HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            // ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, String.class);

           
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            
            ResponseEntity<MaterialDetails[]> respEntity = restTemplate.exchange(theUrl, HttpMethod.GET, entity, MaterialDetails[].class);
            List<orderitems> orderitemslist = ordrepo.findAll();

           

           

            MaterialDetails[] resp = respEntity.getBody();
            for (MaterialDetails var : resp) {
                int quantity = var.getQuantity();
                for (orderitems itm : orderitemslist) {

                 if(var.getName().equals(itm.getProduct_name())){

                    itm.setMaterial_order_id(var.getId());
                    itm.setProduct_type("Raw Material");

                     if(var.getQuantity() > itm.getProduct_quantity()){
                    itm.setAvailability("In Stock");
                   
                    

                    System.out.println(var.getId());
                    quantity = quantity - itm.getProduct_quantity();
                    System.out.println(quantity);
                    ordrepo.save(itm);
                     }
                }
                   
                }
                

             
                
            }



            // System.out.println("Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
            // System.out.println(response);
        } catch (Exception eek) {
            System.out.println("** Exception: " + eek.getMessage());
        }
    }










    @RequestMapping(value = "/showEnquiry", method = RequestMethod.GET)
    public ModelAndView showForm(ModelAndView model) throws ParseException {

     

        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDate localDate = LocalDate.now();

      getDetails();
      getDetailsRaw();


        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int currentdate = calendar.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();
        int currentmonth = date.getMonth();
        long currentTime = date.getTime();

        enquiry enq = new enquiry();
        List<enquiry> plist = enqrepo.findPending();
        List<orderitems> list = ordrepo.pendings();


        

        for (enquiry e : plist) {

            Date date1 = e.getDate_placed();
            int placedmonth = date1.getMonth();

            long placedTime = date1.getTime();

            System.out.println(placedTime);

          //  int times = date1.getHours();

         //   System.out.println(times);

            Calendar c2 = Calendar.getInstance();
            c2.setTime(date1);
            int placeddate = c2.get(Calendar.DAY_OF_MONTH);


            if (currentdate > placeddate) {

                enqrepo.deleteItem(e.getOrder_id());
                ordrepo.deleteItem(e);

            }

            if (currentmonth > placedmonth) {

                enqrepo.deleteItem(e.getOrder_id());
                ordrepo.deleteItem(e);
            }

        

        }

        model.addObject("list", list);
        model.setViewName("placeOrder");

        return model;

    }


    @RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
    public String developerMethod(@RequestParam("myField") int id) {

        newlist.add(id);

        enqrepo.updateItem("confirmed", id);

        return "redirect:/showEnquiry";
    }

    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    public String developerMethodcancel(@RequestParam("myField") int id) {

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


    
    @RequestMapping(value = "/deliveryDetails", method = RequestMethod.GET)
    public ModelAndView showForm2() {
        return new ModelAndView("delivery", "deliverymodel", new deliveryModel());
    }

    @RequestMapping(value = "/confirmDelivery", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("deliverymodel")deliveryModel deliverymodel, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        delivery d = new delivery();
        enquiry eq = enqrepo.getEnquiry(deliverymodel.getOrderid());
        courier cr = crepo.getCourier(deliverymodel.getCourierid());


        d.setDelivery_date(deliverymodel.getDuedate());
        d.setDelivery_location(deliverymodel.getAddress());
        d.setDelivery_type(deliverymodel.getDeliverytype());
        d.setEq(eq);
        d.setDel(cr);
        delrepo.save(d);
               
        enqrepo.updateItem("confirmed", deliverymodel.getOrderid());
      

          
       

        return "index";
    }


    @ResponseBody
    @RequestMapping(value = "/materialEnquiry", method = RequestMethod.GET)
    public List<enquiry> materialEnq(){

        List<enquiry> list = enqrepo.findPending();
            
        return list;
    }




    
    @ResponseBody
    @RequestMapping(value = "/materialOrder", method = RequestMethod.GET)
    public List<enquiry> materialOrd(){

        List<enquiry> list = enqrepo.findConfirmed();
            
        return list;
    }
}