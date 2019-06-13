package com.example.springbootapp.proj1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface deliveryRepo extends CrudRepository<delivery, String> {

    List<delivery> findAll();


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update delivery e set e.delivery_status=:#{#newVal} where e.delivery_id=:#{#delid}")
    void updateDeliveryStatus(@Param("newVal") String newVal, @Param("delid") int delid);


    

}