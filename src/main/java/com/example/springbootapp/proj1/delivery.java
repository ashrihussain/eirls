package com.example.springbootapp.proj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery", schema = "nCxJspI8Zf")
public class delivery{


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "delivery_id")
    private int delivery_id;

	public int getDelivery_id() {
		return this.delivery_id;
	}

	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}


    @Column(name = "delivery_location")
    private String delivery_location;

	public String getDelivery_location() {
		return this.delivery_location;
	}

	public void setDelivery_location(String delivery_location) {
		this.delivery_location = delivery_location;
	}


    @Column(name = "delivery_date")
    private String delivery_date;

	public String getDelivery_date() {
		return this.delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}


    @Column(name = "delivery_type")
    private String delivery_type;

	public String getDelivery_type() {
		return this.delivery_type;
	}

	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}



    @OneToOne
    @JoinColumn(name = "order_id", nullable = true)
    private enquiry eq;

	public enquiry getEq() {
		return this.eq;
	}

	public void setEq(enquiry eq) {
		this.eq = eq;
    }
    
     @ManyToOne
     @JoinColumn(name = "courier_id", nullable = true)
     private courier del;

	public courier getDel() {
		return this.del;
	}

	public void setDel(courier del) {
		this.del = del;
	}





}