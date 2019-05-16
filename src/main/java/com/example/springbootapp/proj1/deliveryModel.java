package com.example.springbootapp.proj1;

public class deliveryModel {

    private int orderid;

    private int courierid;

    private String address;

    private String duedate;

    private String deliverytype;

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCourierid() {
		return this.courierid;
	}

	public void setCourierid(int courierid) {
		this.courierid = courierid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDuedate() {
		return this.duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getDeliverytype() {
		return this.deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

}