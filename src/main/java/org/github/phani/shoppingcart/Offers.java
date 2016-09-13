package org.github.phani.shoppingcart;

import java.math.BigDecimal;

public class Offers {
		
	public BigDecimal buyOneGetOneFree(Integer count, Double price){
		return price.compareTo(BigDecimal.ZERO.doubleValue()) > 0 ? BigDecimal.valueOf((count/2) * price).add(BigDecimal.valueOf((count % 2) * price)) : BigDecimal.ZERO;
	}
	
	
	public BigDecimal priceOfThreeforTwo(Integer count, Double price){
		return price.compareTo(BigDecimal.ZERO.doubleValue()) > 0 ? BigDecimal.valueOf((count/3) * 2 * price).add(BigDecimal.valueOf((count % 3) * price)) : BigDecimal.ZERO;
	}
	
	public BigDecimal findOfferForFruits(String fruit,Integer count, Double price){
		
		switch(fruit){
		case "Apple":
			return buyOneGetOneFree(count, price);
		case "Orange":
			return priceOfThreeforTwo(count, price);
		default:
			return BigDecimal.ZERO;
		}
	}

}
