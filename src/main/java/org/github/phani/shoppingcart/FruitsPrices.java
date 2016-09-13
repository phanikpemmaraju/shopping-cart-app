package org.github.phani.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class FruitsPrices {
	
	private final Map<String,Double> priceList = new HashMap<>();
	
	public Double getPriceForFruit(String fruit){
		if(fruit == null)
			throw new NullPointerException();
		
		return priceList.containsKey(fruit) ? priceList.get(fruit) : 0.0;
	}
	
	public FruitsPrices(){
		priceList.put("Apple", 0.60);
		priceList.put("Orange", 0.25);
	}
	
	

}
