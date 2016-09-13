package org.github.phani.shoppingcart;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
	
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() throws Exception {
		shoppingCart = new ShoppingCart();
	}

	@After
	public void tearDown() throws Exception {
		shoppingCart = null;
	}
	
    @Test(expected = NullPointerException.class)
    public void testCheckOutWithOffersForNullPointerException() throws Exception {
        List<String> fruitsList = null;
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"£0.0");
    }

    @Test
    public void testCheckOutWithOffersForEmptyFruits() throws Exception {
        List<String> fruitsList = Arrays.asList("");
        assertEquals("no items to scan",shoppingCart.checkOutWithOffers(fruitsList),"");
    }
    
    @Test
    public void testCheckOutWithOffersForInvalidFruit() throws Exception {
        List<String> fruitsList = Arrays.asList("Banana");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"");
    }


    @Test
    public void testCheckOutWithOffersForAppleFruit() throws Exception {
        List<String> fruitsList = Arrays.asList("Apple","Apple");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"£0.60");        
    }
    
    @Test
    public void testCheckOutWithOffersForOrangeFruit() throws Exception {        
        List<String> fruitsList = Arrays.asList("Orange","Orange","Orange");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"£0.50");
    }


    @Test
    public void testCheckOutForMultipleFruits() throws Exception {
        List<String> fruitsList = Arrays.asList("Apple","Apple","Orange");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"£0.85");

        fruitsList = Arrays.asList("Apple","Apple","Orange","Orange","Orange");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"£1.10");
        
        fruitsList = Arrays.asList("Orange","Orange","Orange","Apple","Apple","Apple");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"£1.70");

        fruitsList = Arrays.asList("Apple","Orange","Orange","Apple","Orange","Orange");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOutWithOffers(fruitsList),"£1.35");

    }
    
}
