package com.example.springbootapp.proj1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface deliveryRepo extends CrudRepository<delivery, String> {

    List<delivery> findAll();

}