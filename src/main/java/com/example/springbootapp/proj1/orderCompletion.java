package com.example.springbootapp.proj1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class orderCompletion {

    @Id
    private int order_ref_id;

	public int getOrder_ref_id() {
		return this.order_ref_id;
	}

	public void setOrder_ref_id(int order_ref_id) {
		this.order_ref_id = order_ref_id;
	}



    private String due_date;

	public String getDue_date() {
		return this.due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}



}