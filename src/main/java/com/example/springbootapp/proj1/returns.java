package com.example.springbootapp.proj1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "returns", schema = "nCxJspI8Zf")
public class returns{

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "return_id")
    private int return_id;

	public int getReturn_id() {
		return this.return_id;
	}

	public void setReturn_id(int return_id) {
		this.return_id = return_id;
	}



    @Column(name="product_name")
    private String product_name;

	public String getProduct_name() {
		return this.product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


    @Column(name = "product_quantity")
    private int product_quantity;

	public int getProduct_quantity() {
		return this.product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}


    @Column(name ="return_type")
    private String return_type; 

	public String getReturn_type() {
		return this.return_type;
	}

	public void setReturn_type(String return_type) {
		this.return_type = return_type;
	}


    @Column(name="description")
    private String description;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    @Column(name="return_location")
    private String return_location;

	public String getReturn_location() {
		return this.return_location;
	}

	public void setReturn_location(String return_location) {
		this.return_location = return_location;
	}


    @ManyToOne
	 @JoinColumn(name = "order_id", nullable = true)
	 @JsonIgnore
     private enquiry orderid;

	public enquiry getOrderid() {
		return this.orderid;
	}

	public void setOrderid(enquiry orderid) {
		this.orderid = orderid;
	}

	@Column(name = "return_date")
    private Date return_date;

	public Date getReturn_date() {
		return this.return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}





    
}