package practice;


/**class for tax calculation and price calculation per item*/
public class totalprice {
	
	
	/**method for total price calculation = total tax per item + price per item*/
	public float totalPriceCalculation(float taxPrice, float price){
		
		float finalprice = taxPrice + price;
		return finalprice;
		
	}
	
	/**method to calculate tax per product according to material type*/
	public float taxCalculation(String name, float price, String type){
		
		float totalTax = 0.0f;
		float fixedPerc = 12.5f/100.0f;
		
		// material can be of three type raw, manufacture or imported\
		
		switch(type){
		case "raw":
			totalTax = price*fixedPerc;
			break;
			
		case "manufactured":
			totalTax = (price*fixedPerc)+2.0f/100.0f*(fixedPerc);
			break;
			
		case "imported":
			float taxPrice  = (10.0f/100.0f)*price;
			float finalPrice = totalPriceCalculation(taxPrice,price);
			
			if(finalPrice<=100){
				totalTax = taxPrice + 5;
				
			}else if(finalPrice>100 && finalPrice<=200){
				totalTax = taxPrice + 10;
			}else{
				totalTax =taxPrice + ((5.0f/100.0f) * finalPrice);
			}	
			break;
			
		 default:		System.out.println("Please enter correct item type");
			
		}
		return totalTax;
			
		
		
	}	
		
		
		
		
	}

