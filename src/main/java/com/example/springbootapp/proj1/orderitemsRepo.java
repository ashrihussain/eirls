package com.example.springbootapp.proj1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface orderitemsRepo extends CrudRepository<orderitems, String> {

List<orderitems> findAll();
  

 @Transactional
@Modifying(clearAutomatically = true)
 @Query("Update orderitems i set i.enq=:#{#newVal} where i.orderitems_id=:#{#itemid}")
 void updateItem(@Param("newVal") enquiry newVal, @Param("itemid") int itemid);


  @Transactional
 @Modifying(clearAutomatically = true)
 @Query("delete orderitems e where e.enq=:#{#orderid}")
   void deleteItem(@Param("orderid") enquiry orderid);

   @Query("SELECT o FROM orderitems o WHERE o.enq.order_status = 'pending'")
   List<orderitems> pendings();

   @Query("SELECT o FROM orderitems o WHERE o.enq.order_id=:#{#oid}")
   List<orderitems> getItems(@Param("oid") int oid);
   
 


  @Query("SELECT o FROM orderitems o WHERE o.enq.cid.client_id=:#{#userid}")
  List<orderitems> getClientdetails(@Param("userid") int userid);

}