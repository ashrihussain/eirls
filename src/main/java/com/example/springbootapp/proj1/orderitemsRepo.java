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
@Query("Update orderitems i set i.order_id=:#{#newVal} where i.product_name=:#{#itemName}")
void updateItem(@Param("newVal") int newVal, @Param("itemName") String itemname);

}