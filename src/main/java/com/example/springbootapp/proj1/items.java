package com.example.springbootapp.proj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name  = "products_material", schema = "nCxJspI8Zf")
public class items {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name= "product_id")
    private int product_id;

	public int getProduct_id() {
		return this.product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}




    @Column(name= "product_name")
    private String product_name;

	public String getProduct_name() {
		return this.product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

  

  


}