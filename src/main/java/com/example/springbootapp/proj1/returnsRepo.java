package com.example.springbootapp.proj1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface returnsRepo extends CrudRepository<returns, String>{

    List<returns> findAll();

    @Query("SELECT o FROM returns o WHERE o.return_type = 'Repair'")
     List<returns> findrepairs();

     @Query("SELECT o FROM returns o WHERE o.return_type = 'Refund'")
     List<returns> findrefunds();

     @Query("SELECT o FROM returns o WHERE o.return_type = 'Exchange'")
     List<returns> findexchanges();
}