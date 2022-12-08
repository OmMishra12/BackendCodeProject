package com.springrest.springrest.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Products")
public class Products {
	
	@Id
	private long id;
	
	@NotNull
	@Size(min = 2,message ="TYPE SHOULD BE EITHER PG OR FLAT")
	@Column(name="Type")
	private String type;
	
	@NotNull
	@Size(min = 2,message ="Description SHOULD BE ATLEST 5 WORDS")
	@Column(name="Description")
	private String Description;
	
	
	//generate constructor using fields
	public Products(long id, String type, String description) {
		super();
		this.id = id;
		this.type = type;
		this.Description = description;
	}

	
	//default constructor
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	//GETTERS AND SETTERS OF PROPERTY
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	//TO STRING 
	@Override
	public String toString() {
		return "Products [id=" + id + ", type=" + type + ", Description=" + Description + "]";
	}

}
