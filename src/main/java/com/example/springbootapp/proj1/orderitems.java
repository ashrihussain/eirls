package com.example.springbootapp.proj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "orderitems", schema = "nCxJspI8Zf")
public class orderitems{

	public orderitems(){

	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "orderitems_id")
    private int orderitems_id;

	public int getOrderitems_id() {
		return this.orderitems_id;
	}

	public void setOrderitems_id(int orderitems_id) {
		this.orderitems_id = orderitems_id;
	}


    // @Column(name = "order_id")
    // private int order_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_quantity")
    private int product_quantity;

    @Column(name = "product_price")
    private double product_price;

	@Column(name = "availability")
	private String availability;

	public String getAvailability() {
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}


	// public int getOrder_id() {
	// 	return this.order_id;
	// }

	// public void setOrder_id(int order_id) {
	// 	this.order_id = order_id;
	// }

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

	 @ManyToOne
	 @JoinColumn(name = "order_id", nullable = true)
	 @JsonIgnore
     private enquiry enq;

	public enquiry getEnq() {
		return this.enq;
	}

	public void setEnq(enquiry enq) {
		this.enq = enq;
	}

	@Column(name = "product_status")
	private String product_status;

	public String getProduct_status() {
		return this.product_status;
	}

	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	@Column(name = "material_order_id")
	private Integer material_order_id;


	public Integer getMaterial_order_id() {
		return this.material_order_id;
	}

	public void setMaterial_order_id(Integer material_order_id) {
		this.material_order_id = material_order_id;
	}

	



}