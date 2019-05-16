package com.example.springbootapp.proj1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface userRepo extends CrudRepository<clients, String> {

    List<clients> findAll();
   // List<clients> findByItemname(String itemname);
   // List<clients> findDistinctItempriceByItemname(String Itemname);
    

    @Query("Select i.client_id from clients i")
    List<clients> client_id();

    @Query("SELECT o FROM clients o WHERE o.client_id=:#{#cid}")
     clients getclient(@Param("cid") int cid);







    // update item price where itemname = black shirt
}