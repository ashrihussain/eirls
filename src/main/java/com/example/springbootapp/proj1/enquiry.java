package com.example.springbootapp.proj1;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry", schema = "nCxJspI8Zf")
public class enquiry{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "order_id")  
private int order_id;

	public int getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	@Column(name="client_name")
	private String client_name;

	public String getClient_name() {
		return this.client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}




@Column(name = "client_order_id")
private String client_order_id;

	public String getClient_order_id() {
		return this.client_order_id;
	}

	public void setClient_order_id(String client_order_id) {
		this.client_order_id = client_order_id;
	}


@Column(name = "due_date")
private String due_date;

	public String getDue_date() {
		return this.due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}


@Column(name = "order_status")
private String order_status;

	public String getOrder_status() {
		return this.order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

@Column(name = "cancellation_penalty")
private String cancellation_penalty;

	public String getCancellation_penalty() {
		return this.cancellation_penalty;
	}

	public void setCancellation_penalty(String cancellation_penalty) {
		this.cancellation_penalty = cancellation_penalty;
	}

	@Column(name = "product_name")
	private String product_name;

	public String getProduct_name() {
		return this.product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Column(name = "quantity")
	private int quantity;

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "date_placed")
	private Date date_placed;

	public Date getDate_placed() {
		return this.date_placed;
	}

	public void setDate_placed(Date date_placed) {
		this.date_placed = date_placed;
	}






    public enquiry(){

    }


}