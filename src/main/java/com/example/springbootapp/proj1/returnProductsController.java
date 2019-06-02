package com.example.springbootapp.proj1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class returnProductsController{

    @Autowired
    orderitemsRepo ordrep;

    @Autowired
    enquiryRepo enqrepo;

    @Autowired
    returnsRepo rerepo;

    @Autowired
    itemRepo itemrepo;

    @Autowired
    deliveryRepo delrepo;

    @RequestMapping(value = "/returnItems", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("returnItemsOne", "enquiryplace", new enquiryPlace());


    }


    @RequestMapping(value = "/returnItemsError", method = RequestMethod.GET)
    public ModelAndView showForm2() {
        return new ModelAndView("returnItemsError", "enquiryplace", new enquiryPlace());


    }


    

        @RequestMapping(value = "/returns", method = RequestMethod.POST)
        public String submitdetails(@Valid @ModelAttribute("enquiryplace") enquiryPlace enquiryplace, 
          BindingResult result, ModelMap model) {
            if (result.hasErrors()) {
           
                return "error";
            }   

            Date now = getDate();

           int orderid = Integer.parseInt(enquiryplace.getIdentity());

           List<orderitems> orditemsList = ordrep.getItems(orderid);
           enquiry e = enqrepo.getEnquiry(orderid);
          returns rtn = new returns();

           for (orderitems var : orditemsList) {
               if(var.getProduct_name().equals(enquiryplace.getProductname())){
                    if(var.getProduct_quantity() > enquiryplace.getQuantity()){

                        rtn.setProduct_name(enquiryplace.getProductname());
                        rtn.setOrderid(e);
                        rtn.setProduct_quantity(enquiryplace.getQuantity());
                        rtn.setDescription(enquiryplace.getDescription());
                        rtn.setReturn_location(enquiryplace.getLocation());
                        rtn.setReturn_type(enquiryplace.getReturntype());
                        rtn.setReturn_date(now);

                        rerepo.save(rtn);

                      

                        return "index";

                    }

               }
           }


            
           
 
       

           return "redirect:/returnItemsError";
    }


    @RequestMapping(value = "/viewReturns", method = RequestMethod.GET)
    public ModelAndView showForm2(ModelAndView model) throws ParseException {

       
        List<returns> list = rerepo.findAll();

        model.addObject("list", list);
        model.setViewName("viewReturns");

        return model;
    }
    





    @ModelAttribute("orderList")
    public Map<String, String> getOrderList() {
    
      
      Map<String, String> orderList = new HashMap<String, String>();
     
     List<enquiry> ilist = enqrepo.findConfirmed();
    
     for (enquiry var : ilist) {
    
        orderList.put(String.valueOf(var.getOrder_id()), String.valueOf(var.getOrder_id()));
       
     }
    
    return orderList;
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



  
  @ResponseBody
  @RequestMapping(value = "/productionOrders", method = RequestMethod.GET)
  public List<enquiry> productionOrders(){

      List<enquiry> list = enqrepo.findAll();
          
      return list;
  }

  @ResponseBody
  @RequestMapping(value = "/deliveryNotes", method = RequestMethod.GET)
  public List<delivery> deliveryNotes(){

      List<delivery> list = delrepo.findAll();
          
      return list;
  }

  
}
