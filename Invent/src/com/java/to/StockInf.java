package com.java.to;

public class StockInf {

	 private int Code;
     private String Item;
     private int Quantity;
     //constructors
     //getter-setters
	public void setCode(int Code) {
		this.Code=Code;
		
	}
	public void setItem(String Item) {
		this.Item=Item;
		
	}
	public void setQuantity(int Quantity){
		this.Quantity=Quantity;
	}
	public int getCode(){
		return Code;
	}
	public String getItem(){
		return Item;
	}
	public int getQuantity(){
		return Quantity;
	}
}
