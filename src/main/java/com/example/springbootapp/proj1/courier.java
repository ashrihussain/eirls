package com.example.springbootapp.proj1;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "courier", schema = "nCxJspI8Zf")
public class courier{


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "courier_id") 
    private int courier_id;

	public int getCourier_id() {
		return this.courier_id;
	}

	public void setCourier_id(int courier_id) {
		this.courier_id = courier_id;
	}



    @Column(name ="courier_name")
    private String courier_name;


	public String getCourier_name() {
		return this.courier_name;
	}

	public void setCourier_name(String courier_name) {
		this.courier_name = courier_name;
	}

    @Column(name = "courier_contact")
    private String courier_contact;

	public String getCourier_contact() {
		return this.courier_contact;
	}

	public void setCourier_contact(String courier_contact) {
		this.courier_contact = courier_contact;
	}



	@OneToMany(mappedBy = "del")
	@JsonIgnore
    private Set<delivery> del;

	public Set<delivery> getDel() {
		return this.del;
	}

	public void setDel(Set<delivery> del) {
		this.del = del;
	}

  
    




}