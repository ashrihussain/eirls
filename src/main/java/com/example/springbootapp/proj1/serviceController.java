package com.example.springbootapp.proj1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class serviceController{

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

    @Autowired
    returnsRepo retRepo;





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

  @ResponseBody
  @RequestMapping(value = "/returnRepairs", method = RequestMethod.GET)
  public List<returns> repairs(){

      List<returns> list =  retRepo.findrepairs();
          
      return list;
  }

  @ResponseBody
  @RequestMapping(value = "/returnRefunds", method = RequestMethod.GET)
  public List<returns> refunds(){

      List<returns> list =  retRepo.findrefunds();
          
      return list;
  }

  @ResponseBody
  @RequestMapping(value = "/returnExchange", method = RequestMethod.GET)
  public List<returns> exchanges(){

      List<returns> list =  retRepo.findexchanges();
          
      return list;
  }


  @ResponseBody
  @RequestMapping(value = "/cancelledProducts", method = RequestMethod.GET)
  public List<orderitems> cancelledOrderItems(){

      List<orderitems> list =  ordrepo.cancelledOrders();
          
      return list;
  }





}