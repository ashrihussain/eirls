package com.example.springbootapp.proj1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MaterialDetailsRepo extends CrudRepository<MaterialDetails, String> {

    List<MaterialDetails> findAll();
}