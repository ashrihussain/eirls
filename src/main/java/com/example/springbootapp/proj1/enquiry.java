package com.example.springbootapp.proj1;

import java.util.Date;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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


	@Column(name = "date_placed")
	private Date date_placed;

	public Date getDate_placed() {
		return this.date_placed;
	}

	public void setDate_placed(Date date_placed) {
		this.date_placed = date_placed;
	}

	@OneToMany(mappedBy = "enq")
	@JsonIgnoreProperties("enq")
  private Set<orderitems> ord;

	public Set<orderitems> getOrd() {
		return this.ord;
	}

	public void setOrd(Set<orderitems> ord) {
		this.ord = ord;
	}


	@ManyToOne
	@JoinColumn(name = "client_id", nullable = true)
	private clients cid;

	public clients getCid() {
		return this.cid;
	}

	public void setCid(clients cid) {
		this.cid = cid;
	}


	@OneToOne(mappedBy = "eq")
	@JsonIgnore
	private delivery del;

	public delivery getDel() {
		return this.del;
	}

	public void setDel(delivery del) {
		this.del = del;
	}



	@OneToMany(mappedBy = "orderid")
	@JsonIgnoreProperties("orderid")
  private Set<returns> returns;

	public Set<returns> getReturns() {
		return this.returns;
	}

	public void setReturns(Set<returns> returns) {
		this.returns = returns;
	}


@Column(name ="due_date")
private String due_date;


	public String getDue_date() {
		return this.due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}




    public enquiry(){

    }


}