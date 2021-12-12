package com.assignments.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {

	private List<Item> itemList;
	private Scanner sc = new Scanner(System.in);
	
	
	  void inputItemDetails(){
		itemList = new ArrayList<>();
		Item itemDetail = new Item();
		System.out.println("please enter item name: ");
		String itemName = validateStringdata();
		itemDetail.setName(itemName);
		System.out.println("please enter item type - raw/manufactured/imported: ");
		String itemType = validateType();
		itemDetail.setType(itemType);
		System.out.println("please enter item price: ");
		float itemPrice = validateFloatAndIntValue("float").floatValue();
		System.out.println("please enter itme quantity: ");
		int itemQuantity = validateFloatAndIntValue("int").intValue();
		
		float taxPrice = itemDetail.calculateTax();
		CalculateTaxData taxdata = new CalculateTaxData();
		float totalPrice = taxdata.totalPriceCalculation(taxPrice, itemPrice);	
		itemDetail.setTax(taxPrice);
		itemDetail.setTotalPrice(totalPrice);
		itemList.add(itemDetail);
		System.out.println("thank you for the details, below are the item details you have entered: ");
		display();
		
		
		
		
		
		
		
		
	}
	
	private String validateStringdata(){
		String strinData= sc.nextLine();
		if(strinData == null || strinData.trim().length()==0){
			System.out.println("please enter correct item name, value can't be null or empty");
			validateStringdata();
		}
		
		return strinData;
	}
	
	private String validateType(){
		String typeData = sc.nextLine();
		if(typeData == null || typeData.trim().length()< 0 || !Arrays.asList("raw","manufactured","imported").contains(typeData)){
			System.out.println("please enter correct item type, value can't be null or empty");
			validateType();
		
		}
		return typeData;
	}
	
	private Number validateFloatAndIntValue(String type){
		Number typeValue = null;
		String userInput = null;
		if(type.equalsIgnoreCase("int")){
			userInput = sc.nextLine();
			try{
				typeValue = Integer.parseInt(userInput);	
			}catch(NumberFormatException e){
				System.out.println("please enter valid quantity value, try again");
				validateFloatAndIntValue(type);
				
			}
		}else if(type.equalsIgnoreCase("float")){
			userInput = sc.nextLine();
			try{
				typeValue = Float.parseFloat(userInput);
			}catch(NumberFormatException e){
				System.out.println("please enter valid price value, try again");
				validateFloatAndIntValue(type);
			}
			
		}
		if(userInput == null || userInput.trim().length()<0){
			System.out.println("please enter valid input value, try again");
			validateFloatAndIntValue(type);
		}
		
		
		return typeValue;
	}
	
	private void display(){
		
		System.out.println("Item name is "+itemList.get(0).getName());
		System.out.println("Item type is "+itemList.get(0).getType());
		System.out.println("Item price is "+itemList.get(0).getPrice());
		System.out.println("Item quantity is "+itemList.get(0).getQuantity());
		System.out.println("Item tax is "+itemList.get(0).getTax());
		System.out.println("Item price is "+itemList.get(0).getTotalPrice());
		
		
		
		
	}
	
	
	
}
