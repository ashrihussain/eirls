package com.example.springbootapp.proj1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface courierRepo extends CrudRepository<courier, String> {

    List<courier>findAll();

    
    @Query("SELECT o FROM courier o WHERE o.courier_id=:#{#cid}")
     courier getCourier(@Param("cid") int cid);
    
}