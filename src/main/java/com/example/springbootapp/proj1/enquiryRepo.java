package com.example.springbootapp.proj1;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface enquiryRepo extends CrudRepository<enquiry, String> {

    List<enquiry> findAll();
   // List<clients> findByItemname(String itemname);
   // List<clients> findDistinctItempriceByItemname(String Itemname);
   
     @Query("SELECT o FROM enquiry o WHERE o.order_status = 'pending'")
     List<enquiry> findPending();


     @Query("SELECT o FROM enquiry o WHERE o.order_status = 'confirmed'")
     List<enquiry> findConfirmed();

     @Query("SELECT o.client_name FROM enquiry o WHERE o.cid=:#{#cid}")
     String findCustomer(@Param("cid") clients cid);


     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update enquiry e set e.order_status=:#{#newVal} where e.order_id=:#{#orderid}")
     void updateItem(@Param("newVal") String newVal, @Param("orderid") int orderid);

    //  @Transactional
    //  @Modifying(clearAutomatically = true)
    //  @Query("update enquiry e set e.order_status=:#{#newVal}, e.date_placed=:#{#date}, e.client_name=:#{#name}, e.due_date=:#{#duedate} where e.order_id=:#{#orderid}")
    //  void updateOrder(@Param("newVal") String newVal, @Param("date") Date date, @Param("name") String name, @Param("duedate") String duedate, @Param("orderid") int orderid);


    @Query("SELECT o FROM enquiry o WHERE o.order_id=:#{#oid}")
     enquiry getEnquiry(@Param("oid") int oid);
  
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("delete enquiry e where e.order_id=:#{#orderid}")
     void deleteItem(@Param("orderid") int orderid);


    // update item price where itemname = black shirt
}