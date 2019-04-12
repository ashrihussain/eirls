package com.example.springbootapp.proj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "order_items" , schema = "nCxJspI8Zf")
public class orderitems{

    @Id
    @Column(name = "orderitems_id")
    private int orderitems_id;

	public int getOrderitems_id() {
		return this.orderitems_id;
	}

	public void setOrderitems_id(int orderitems_id) {
		this.orderitems_id = orderitems_id;
	}


    @Column(name = "order_id")
    private int order_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_quantity")
    private int product_quantity;

    @Column(name = "product_price")
    private double product_price;


    public orderitems(){}


	public int getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getProduct_name() {
		return this.product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_quantity() {
		return this.product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public double getProduct_price() {
		return this.product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}




}