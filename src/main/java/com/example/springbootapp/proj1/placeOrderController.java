package com.example.springbootapp.proj1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.scheduling.annotation.Async;
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

    @Autowired
    itemRepo irepo;
    


    List<Integer> newlist = new ArrayList<>();

   
     

    @RequestMapping("/home")
    public String index() {

    




        return "index";
    }








    @RequestMapping(value = "/showEnquiry", method = RequestMethod.GET)
    public ModelAndView showForm(ModelAndView model) throws ParseException {

     
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDate localDate = LocalDate.now();

   


        Date now = getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int currentdate = calendar.get(Calendar.DAY_OF_MONTH);
        
        int currentmonth = now.getMonth();
        long currentTime = now.getTime();

        
        List<enquiry> plist = enqrepo.findPending();
        List<orderitems> list = ordrepo.pendings();


        

        for (enquiry e : plist) {

            Date date1 = e.getDate_placed();
            int placedmonth = date1.getMonth();

            long placedTime = date1.getTime();

            System.out.println(placedTime);

         

            Calendar c2 = Calendar.getInstance();
            c2.setTime(date1);
            int placeddate = c2.get(Calendar.DAY_OF_MONTH);


            long diff = now.getTime() - date1.getTime();

            long diffDays = diff / (24 * 60 * 60 * 1000);
            long diffHours = diff / (60 * 60 * 1000) % 24;

            System.out.println(diffHours);

            System.out.println(diffDays);

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

        List<orderitems> olist = ordrepo.getItems(id);

        for (orderitems var : olist) {
            ordrepo.cancelItem("cancelled", var.getOrderitems_id());
            
        }

        enqrepo.updateItem("cancelled", id);

        return "redirect:/showOrder";

    }

    @RequestMapping(value = "/cancelOrderItem", method = RequestMethod.POST)
    public String cancelItem(@RequestParam("myField") int id) {

        ordrepo.cancelItem("cancelled", id);

        return "redirect:/selectOrder";

    }


    @RequestMapping(value = "/showOrder", method = RequestMethod.GET)
    public ModelAndView showForm2(ModelAndView model) throws ParseException {

        enquiry enq = new enquiry();
        List<enquiry> list = enqrepo.findConfirmed();

        model.addObject("list", list);
        model.setViewName("showOrder");

        return model;
    }


    @RequestMapping(value = "/cancelledOrders", method = RequestMethod.GET)
    public ModelAndView showCancelled(ModelAndView model) throws ParseException {

     
        List<orderitems> list = ordrepo.cancelledOrders();

        model.addObject("list", list);
        model.setViewName("cancelledOrders");

        return model;
    }




    @RequestMapping(value = "/selectOrder", method = RequestMethod.GET)
    public ModelAndView historyForm() {
        return new ModelAndView("selectOrderItem", "deliverymodel", new deliveryModel());
    }

    @RequestMapping(value = "/showOrderItems", method = RequestMethod.POST)
    public ModelAndView showHistory(@Valid @ModelAttribute("deliverymodel")deliveryModel deliverymodel, 
      BindingResult result, ModelMap models, ModelAndView model) {
      
        int results = Integer.parseInt(deliverymodel.getIdentity());
       
        List<orderitems> list = ordrepo.getItems(results);
        model.addObject("list", list);
        model.setViewName("showOrderItems");

        return model;
      

          
       

       
    }


    
    @RequestMapping(value = "/deliveryDetails", method = RequestMethod.GET)
    public ModelAndView placeOrders() {
        return new ModelAndView("delivery", "deliverymodel", new deliveryModel());
    }

    @RequestMapping(value = "/confirmDelivery", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("deliverymodel")deliveryModel deliverymodel, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        delivery d = new delivery();
        enquiry eq = enqrepo.getEnquiry(Integer.parseInt(deliverymodel.getIdentity()));
        courier cr = crepo.getCourier(Integer.parseInt(deliverymodel.getCourier()));


        d.setDelivery_date(deliverymodel.getDuedate());
        d.setDelivery_location(deliverymodel.getAddress());
        d.setDelivery_type(deliverymodel.getDeliverytype());
        d.setEq(eq);
        d.setDel(cr);
        delrepo.save(d);
               
        enqrepo.updateItem("confirmed", Integer.parseInt(deliverymodel.getIdentity()));
      

          
       

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


    @ModelAttribute("confirmedOrderList")
    public Map<String, String> getConfirmedOrderList() {
    
      
      Map<String, String> orderList = new HashMap<String, String>();
     
     List<orderitems> ilist = ordrepo.confirmedOrders();
    
     for (orderitems var : ilist) {

        if(var.getProduct_status().equals("cancelled")){

        }else{

            orderList.put(String.valueOf(var.getEnq().getOrder_id()), String.valueOf(var.getEnq().getOrder_id()));
        }


        
        
      
       
     }
    
    return orderList;
    }

    
    @ModelAttribute("orderList")
    public Map<String, String> getOrderList() {
    
      
      Map<String, String> orderList = new HashMap<String, String>();
     
     List<enquiry> ilist = enqrepo.findPending();
    
     for (enquiry var : ilist) {
    
        orderList.put(String.valueOf(var.getOrder_id()), String.valueOf(var.getOrder_id()));
       
     }
    
    return orderList;
    }

    @ModelAttribute("courierList")
    public Map<String, String> getCourier() {
    
      
      Map<String, String> courierList = new HashMap<String, String>();
     
     List<courier> ilist = crepo.findAll();
    
     for (courier var : ilist) {
    
        courierList.put(String.valueOf(var.getCourier_id()), String.valueOf(var.getCourier_id()));
       
     }
    
    return courierList;
    }

    private Date getDate() {

        Date date = new Date();
    
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        // df.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
    
        String strDate = df.format(date);
    
        Date newDate = null;
        try {
          newDate = df.parse(strDate);
        } catch (ParseException e) {
          e.printStackTrace();
        }
    
        return newDate;
      }

}