package com.example.springbootapp.proj1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface orderitemsRepo extends CrudRepository<orderitems, String> {

List<orderitems> findAll();

}