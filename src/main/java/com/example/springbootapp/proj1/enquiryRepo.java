package com.example.springbootapp.proj1;

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
    

    // @Query("Select i.client_name from clients i")
    // List<clients> client_name();

     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update enquiry e set e.order_status=:#{#newVal} where e.order_id=:#{#orderid}")
     void updateItem(@Param("newVal") String newVal, @Param("orderid") int orderid);

  



    // update item price where itemname = black shirt
}