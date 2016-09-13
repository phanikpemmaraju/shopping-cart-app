package org.github.phani.shoppingcart;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;


public class ShoppingCart {
	
    final Locale locale = Locale.UK;
    final NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
	final FruitsPrices fruitPrices = new FruitsPrices();        

    public String checkOut(final List<String> data) {

        final BigDecimal checkOutPrice = 
        		data.stream()
        			.map(fruit -> getPricesOfFruits().apply(fruit))
        			.reduce(BigDecimal.ZERO,BigDecimal::add);
        
        return checkOutPrice.compareTo(BigDecimal.ZERO) > 0 ? currency.format(checkOutPrice) : "";

    }

    
    private Function<String,BigDecimal> getPricesOfFruits(){
        return s -> BigDecimal.valueOf(fruitPrices.getPriceForFruit(s));
    }

}
