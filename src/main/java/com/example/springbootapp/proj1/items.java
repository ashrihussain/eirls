package com.example.springbootapp.proj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name  = "items", schema = "sales")
public class items {

    @Id
    @Column(name= "item_id")
    private int itemID;


	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
    @Column(name= "item_price")
    private int itemprice;
    @Column(name= "item_quantity")
    private int itemQuantiy;
    
    @Column(name="item_name")
    private String itemname;

    public items() {
    }

    public items(String itemname) {
        super();
        this.itemname = itemname;
   
    }

  


}