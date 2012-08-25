package com.example.debtmanager.model;

public class Debt {
	
	private int mId;
	private String mName;
	private Double mAmount;
	
	public Debt(int pId, String pName, Double pAmount) {
		this.mId = pId;
		this.mName = pName;
		this.mAmount = pAmount;
	}
	
	public int getId() {
		return this.mId;
	}
	
	public String getName() {
		return this.mName;
	}
	
	public Double getAmount() {
		return this.mAmount;
	}
	
	public void setId(int pId) {
		this.mId = pId;
	}
	
	public void setName(String pName) {
		this.mName = pName;
	}
	
	public void setAmount(Double pAmount) {
		this.mAmount = pAmount;
	}
}
