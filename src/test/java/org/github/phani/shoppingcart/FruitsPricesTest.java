package org.github.phani.shoppingcart;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FruitsPricesTest {
	
	private FruitsPrices fruitsPrices;

	@Before
	public void setUp() throws Exception {
		fruitsPrices = new FruitsPrices();
	}

	@After
	public void tearDown() throws Exception {
		fruitsPrices = null;
	}

	@Test(expected=NullPointerException.class)
	public void testNullPointerException() {
		assertEquals("null value provided for fruit",fruitsPrices.getPriceForFruit(null), Double.valueOf(0.0));
	}
	
	@Test
	public void testWithEmptyFruit() {
		assertEquals("fruit not available in the list",fruitsPrices.getPriceForFruit(" "), Double.valueOf(0.0));
	}
	
	@Test
	public void testWithInvalidFruit() {
		assertEquals("fruit not available in the list",fruitsPrices.getPriceForFruit("Banana"), Double.valueOf(0.0));
	}
	
	@Test
	public void testWithValidFruit() {
		assertEquals("available fruit not returned with expected price",fruitsPrices.getPriceForFruit("Apple"), Double.valueOf(0.60));
	}
	

}
