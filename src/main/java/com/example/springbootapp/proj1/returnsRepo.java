package com.example.springbootapp.proj1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface returnsRepo extends CrudRepository<returns, String>{

    List<returns> findAll();

    
}