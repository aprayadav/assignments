package com.assignments.assignment;

import java.util.*;

enum ItemTypes {
	  raw, manufactured, imported
	}

/** class to calculate final price and tax */
class CalculateTaxData{
	
	static float totalTax = 0.0f;
	static float fixedPerc = 12.5f/100.0f;
	
	/** method to calculate total price*/
    public static float totalPriceCalculation(float taxPrice, float price){
    	return taxPrice + price;
    	
	}
    
    /** method to calculate tax when type is raw*/
	public static float calculateRawTypeTax(float price){
		return price*fixedPerc;
		
	}
	
	/** method to calculate tax when type is manufactured*/
	public static float calculateManufacturedTypeTax(float price){
		return (price*fixedPerc)+2.0f/100.0f*(fixedPerc);
		
	}
	
	/** method to calculate tax when type is imported*/
	public static float calculateImportedTypeTax(float price){
		float taxPrice  = (10.0f/100.0f)*price;
		float finalPrice = totalPriceCalculation(taxPrice,price);
		
		if(finalPrice<=100){
			totalTax = taxPrice + 5;
			
		}else if(finalPrice>100 && finalPrice<=200){
			totalTax = taxPrice + 10;
		}else{
			totalTax =taxPrice + ((5.0f/100.0f) * finalPrice);
		}
		return totalTax;
	}
	
}

/**class to set item details and call appropriate tax calculation method on the basis of their types*/
public class Item {

	private String name;
	private String type;
	private float price;
	private int quantity;
	private float tax;
	private float totalPrice;
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public void setTax(float tax){
		this.tax = tax;
	}
	
	public void setTotalPrice(float totalPrice){
		this.totalPrice = totalPrice;
	}
	
	public String getName(){
		return name;
	}
	
	public String getType(){
		return type;
	}
	
	public float getPrice(){
		return price;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public float getTax(){
		return tax;
	}
	
	public float getTotalPrice(){
		return totalPrice;
	}
	
	
	/** method to call appropriate method according to their type*/
	public float calculateTax(){
		
		switch(type){
		
		case "raw":
			tax =  CalculateTaxData.calculateRawTypeTax(price);
			break;
			
		case "manufacture":
			tax = CalculateTaxData.calculateManufacturedTypeTax(price);
			break;
			
		case "imported":
			tax = CalculateTaxData.calculateImportedTypeTax(price);
			break;
			
		 default:		System.out.println("Please enter correct item type,this is wrong type "+type);
			
		
		}
		
		return tax;
		
	}
}
