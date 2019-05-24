package com.quinn.tacoloco.model;

public class Order {

	private Double subTotal;
	private Double grandTotal;
	private Integer chickenTacoQty;
	private Integer vegetableTacoQty;
	private Integer beefTacoQty;
	private Integer chorizoTacoQty;
	private Boolean discountApplied;

	public Order() {

	}

	public Order(Double subTotal, Double grandTotal, Integer chickenTacoQty, Integer vegetableTacoQty,
			Integer beefTacoQty, Integer chorizoTacoQty, Boolean discountApplied) {
		super();
		this.subTotal = subTotal;
		this.grandTotal = grandTotal;
		this.chickenTacoQty = chickenTacoQty;
		this.vegetableTacoQty = vegetableTacoQty;
		this.beefTacoQty = beefTacoQty;
		this.chorizoTacoQty = chorizoTacoQty;
		this.discountApplied = discountApplied;

	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Integer getChickenTacoQty() {
		return chickenTacoQty;
	}

	public void setChickenTacoQty(Integer chickenTacoQty) {
		this.chickenTacoQty = chickenTacoQty;
	}

	public Integer getVegetableTacoQty() {
		return vegetableTacoQty;
	}

	public void setVegetableTacoQty(Integer vegetableTacoQty) {
		this.vegetableTacoQty = vegetableTacoQty;
	}

	public Integer getBeefTacoQty() {
		return beefTacoQty;
	}

	public void setBeefTacoQty(Integer beefTacoQty) {
		this.beefTacoQty = beefTacoQty;
	}

	public Integer getChorizoTacoQty() {
		return chorizoTacoQty;
	}

	public void setChorizoTacoQty(Integer chorizoTacoQty) {
		this.chorizoTacoQty = chorizoTacoQty;
	}

	public Boolean getDiscountApplied() {
		return discountApplied;
	}

	public void setDiscountApplied(Boolean discountApplied) {
		this.discountApplied = discountApplied;
	}
	

}
