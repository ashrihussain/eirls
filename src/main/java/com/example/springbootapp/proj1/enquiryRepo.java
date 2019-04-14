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

    // @Transactional
    // @Modifying(clearAutomatically = true)
    // @Query("create items i set i.itemprice=:#{#newVal} where i.itemname=:#{#itemName}")
    // void updateItem(@Param("newVal") int newVal, @Param("itemName") String itemname);

  



    // update item price where itemname = black shirt
}