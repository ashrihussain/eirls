package com.example.springbootapp.proj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients", schema = "nCxJspI8Zf")
public class clients{

    @Id
    @Column(name = "client_id")
    private String client_id;

	public String getClient_id() {
		return this.client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}


	


    @Column(name = "client_name")
    private String client_name;

	public String getClient_name() {
		return this.client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}


    @Column(name = "client_trade")
    private String client_trade;

	public String getClient_trade() {
		return this.client_trade;
	}

	public void setClient_trade(String client_trade) {
		this.client_trade = client_trade;
	}


    @Column(name = "client_address")
    private String client_address;

	public String getClient_address() {
		return this.client_address;
	}

	public void setClient_address(String client_address) {
		this.client_address = client_address;
	}


    @Column(name = "client_contact")
    private String client_contact;

	public String getClient_contact() {
		return this.client_contact;
	}

	public void setClient_contact(String client_contact) {
		this.client_contact = client_contact;
	}


    @Column(name = "client_status")
    private String client_status;

	public String getClient_status() {
		return this.client_status;
	}

	public void setClient_status(String client_status) {
		this.client_status = client_status;
	}

    
    public clients() {
    }

    public clients (String client_id, String client_name, String client_trade, String client_address, String client_contact, String client_status) {
        super();
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_trade = client_trade;
        this.client_address = client_address;
        this.client_contact = client_contact;
        this.client_status = client_status;
    }


}