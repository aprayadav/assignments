import java.util.*;
import java.lang.*;

class totalPrice{
	
public float totalPriceCalculator(float taxPrice, float price){
//method to calucate total price of an item	
	float finalprice = taxPrice + price;
	return finalprice;
}	

}

class calculateTax extends totalPrice{
	
public float calculateTaxResult(String type, float price, String name){
	//method to calculate tax per product according to material type
	
	totalPrice total = new totalPrice();
	float totalTax = 0.0f;
	float fixedPerc = 12.5f/100.0f;
	
	// material can be of three type raw, manufacture or imported
	if("raw".equalsIgnoreCase(type)){
		
		totalTax = price*fixedPerc;
		return totalTax;
		
	}else if("manufactured".equalsIgnoreCase(type)){
		totalTax = (price*fixedPerc)+2.0f/100.0f*(fixedPerc);
		return totalTax;
		
	}else{
		
		float taxPrice  = (10.0f/100.0f)*price;
		float finalPrice = total.totalPriceCalculator(taxPrice,price);
		float finalImportedPrice = 0.0f;
		
		if(finalPrice<=100){
		finalImportedPrice = taxPrice + 5;
			
		}else if(finalPrice>100 && finalPrice<=200){
			finalImportedPrice = taxPrice + 10;
		}else{
		finalImportedPrice =taxPrice + ((5.0f/100.0f) * finalPrice);
		}	
		
		
		return finalImportedPrice;
		
	}
	
}	
	
	
	
	
	
}

public class InvesntoryManagementSystem{
public void printValue(String name, float price, String type, int quantity){
    
    //method to print input values
System.out.println("Item Name- "+name);
System.out.println("Item Price- "+price);
System.out.println("Item Type- "+type);
System.out.println("Item Quantity- "+quantity);
}

public boolean validateData(String arry[]){
    //method to validate if user have entered all data or not
	
  if(arry.length==4){
      return true;
  }else
  return false;
  
}

public static void main(String args[]){
InvesntoryManagementSystem obj = new InvesntoryManagementSystem();
calculateTax taxcal  = new calculateTax();
boolean validationResult = obj.validateData(args);

if(validationResult){
    // to check if user have enterd values or not
    
    
        obj.printValue(args[0],Float.parseFloat(args[1]),args[2],Integer.parseInt(args[3]));


float tax = taxcal.calculateTaxResult(args[2],Float.parseFloat(args[1]),args[0]);
System.out.println("Total sales tax liability of item "+args[0]+" is "+tax);


float totalPriceOfItem = taxcal.totalPriceCalculator(tax,Float.parseFloat(args[1]));
System.out.println("Total price of item "+args[0]+" is "+totalPriceOfItem);
    
 
 System.out.println("Do you wish to enter more item details, y/n");
 Scanner sc= new Scanner(System.in);
 String str= sc.nextLine();
if("y".equalsIgnoreCase(str)){
	System.out.println("enter next item details -  Name , Price, Type (Raw , Manufactured, Imported) and  Quantity");
	
}
   
}else{
    
    System.out.println("Please enter all four parameters - Name , Price, Type (Raw , Manufactured, Imported) and  Quantity");
}




}



}