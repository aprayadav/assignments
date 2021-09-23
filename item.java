/**
 * 
 */
package practice;

import java.util.*;
import java.lang.*;

/**
 * 
 * 
 * main class to take item details like item name, item price, item type (raw,manufactured,imported) and item quantity
 *
 */
public class item {


	String itemName;
	float itemPrice;
	String itemType;
	int itmeQuantity;
	float taxPrice;
	float totalPrice;
	
	/**method to take user input and call methods for tax calculation and price calculation*/
	public void getItemDetails(){
		
		boolean validatePrice = false;
		Scanner sc= new Scanner(System.in);
		//taking input for item name
		System.out.println("Enter item name");
		itemName = sc.nextLine();
		
		//ask user to enter data until user enter correct data
		while(!validatePrice){
			//taking input for item price
			System.out.println("Enter item price");
			try{
				itemPrice = Float.parseFloat(sc.nextLine());
				validatePrice = true;
			}catch(Exception e){
				System.out.println("Please enter correct price value");
			}
			
		}
		validatePrice = false;
		//taking input for item type
		System.out.println("Enter item type - Raw, Manufactured, Imported");
		itemType = sc.nextLine();
		while(itemType.isEmpty()){
			System.out.println("please enter item type as it's mandatory field");
			itemType = sc.nextLine();
		}
		
		
		//taking input for item quantity
		while(!validatePrice){
			System.out.println("Enter item quantity");
			try{
				itmeQuantity = Integer.parseInt(sc.nextLine());
				validatePrice = true;
			}catch(NumberFormatException e){
				System.out.println("please enter correct item quantity");
			}
		}
		
		
		totalprice total = new totalprice();// total price class object
		
		taxPrice = total.taxCalculation(itemName, itemPrice, itemType);//method to calculate tax per item
		totalPrice = total.totalPriceCalculation(taxPrice, itemPrice);// method to calculate price per item
		
		printItemDetails();// method to print all the data of item
		
	}
	/** method to print all the data of item*/
	public void printItemDetails(){
		
		System.out.println("Item Name- "+itemName);
		System.out.println("Item Type- "+itemType);
		System.out.println("Item Price- "+itemPrice);
		System.out.println("Item Quantity- "+itmeQuantity);
		System.out.println("Item Total Tax- "+taxPrice);
		System.out.println("Item Price- "+totalPrice);
		
	}
	public static void main(String[] args) {
		
		
		item itemObj = new item();
		itemObj.getItemDetails();
		
		//ask if user wants to enter more items details
		System.out.println("Do you wish to enter more item details? yes/no");
		Scanner sc= new Scanner(System.in);
		String userChoice = sc.nextLine();
		if("yes".equalsIgnoreCase(userChoice)){
			itemObj.getItemDetails();
		}
			
		
		
	}

}
