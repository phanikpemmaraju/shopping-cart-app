package org.github.phani.shoppingcart;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ShoppingCart {
	
    final Locale locale = Locale.UK;
    final NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
	final FruitsPrices fruitPrices = new FruitsPrices();      
	final Offers offers = new Offers();
    
    public String checkOutWithOffers(List<String> data) {

        final BigDecimal checkOutPrice =    		
        		data.stream()
        			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        			.entrySet()
        			.stream()
        			.map(mapper -> getOffersPrice().apply(mapper))
        			.reduce(BigDecimal.ZERO,BigDecimal::add);

        return checkOutPrice.compareTo(BigDecimal.ZERO) > 0 ? currency.format(checkOutPrice) : "";

    }

    
    private Function<Entry<String,Long>,BigDecimal> getOffersPrice(){
        return entry -> offers.findOfferForFruits(entry.getKey(), entry.getValue().intValue(), fruitPrices.getPriceForFruit(entry.getKey()));  		
    }


}
