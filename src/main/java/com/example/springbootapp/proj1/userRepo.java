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


     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update clients e set e.client_name=:#{#newVal} where e.client_id=:#{#cid}")
     void updateName(@Param("newVal") String newVal, @Param("cid") int cid);


     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update clients e set e.client_trading_name=:#{#newVal} where e.client_id=:#{#cid}")
     void updateTrading(@Param("newVal") String newVal, @Param("cid") int cid);


     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update clients e set e.client_address=:#{#newVal} where e.client_id=:#{#cid}")
     void updateAddress(@Param("newVal") String newVal, @Param("cid") int cid);



 @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update clients e set e.client_contact=:#{#newVal} where e.client_id=:#{#cid}")
     void updateContact(@Param("newVal") String newVal, @Param("cid") int cid);

     
 @Transactional
 @Modifying(clearAutomatically = true)
 @Query("update clients e set e.client_status=:#{#newVal} where e.client_id=:#{#cid}")
 void updateCredit(@Param("newVal") String newVal, @Param("cid") int cid);


     
 @Transactional
 @Modifying(clearAutomatically = true)
 @Query("update clients e set e.client_age=:#{#newVal} where e.client_id=:#{#cid}")
 void updateAge(@Param("newVal") int newVal, @Param("cid") int cid);

    // update item price where itemname = black shirt
}