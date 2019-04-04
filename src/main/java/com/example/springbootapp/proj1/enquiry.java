package com.example.springbootapp.proj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry", schema = "nCxJspI8Zf")
public class enquiry{

@Id
@Column(name = "order_id")  
private int order_id;

	public int getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


@Column(name = "user_name")
private String user_name;

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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


    public enquiry(){

    }


}