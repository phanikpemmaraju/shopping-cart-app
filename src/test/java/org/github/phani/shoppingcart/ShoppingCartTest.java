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
    public void testCheckOutForNullPointerException() throws Exception {
        List<String> fruitsList = null;
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£0.0");
    }

    @Test
    public void testCheckOutForEmptyFruits() throws Exception {
        List<String> fruitsList = Arrays.asList("");
        assertEquals("no items to scan",shoppingCart.checkOut(fruitsList),"");
    }
    
    @Test
    public void testCheckOutForInvalidFruit() throws Exception {
        List<String> fruitsList = Arrays.asList("Banana");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"");
    }


    @Test
    public void testCheckOutForSingleFruit() throws Exception {
        List<String> fruitsList = Arrays.asList("Apple");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£0.60");
        
        fruitsList = Arrays.asList("Orange");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£0.25");
    }

    @Test
    public void testCheckOutForMultipleFruits() throws Exception {
        List<String> fruitsList = Arrays.asList("Apple","Orange");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£0.85");

        fruitsList = Arrays.asList("Apple","Apple","Orange","Apple");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£2.05");
        
        fruitsList = Arrays.asList("Orange","Orange","Orange","Apple");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£1.35");

        fruitsList = Arrays.asList("Apple","Orange","Orange","Apple");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£1.70");

    }
    
    /*
     *  For the below testcase, it's assumed that string values for fruit names are case sensitive
     * 
     */
    
    @Test
    public void testCheckOutForCaseSensitive() throws Exception {
        List<String> fruitsList = Arrays.asList("apple","Orange");
        assertEquals("expected and actual prices not equal",shoppingCart.checkOut(fruitsList),"£0.25");
    }




}
