package com.quinn.tacoloco.model;

public class Taco {

	private String description;
	private Integer id;
	private Double price;
	
	

	public Taco(String description, Integer id, Double price) {
		super();
		this.description = description;
		this.id = id;
		this.price = price;
	}
	
	public Taco() {
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
