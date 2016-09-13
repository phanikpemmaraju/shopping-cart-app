package org.github.phani.shoppingcart;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OffersTest {
	
	private Offers offers;

	@Before
	public void setUp() throws Exception {
		offers = new Offers();
	}

	@After
	public void tearDown() throws Exception {
		offers = null;
	}

	@Test
	public void testForBuyOneGetOneFree() {
		assertEquals("expected and actual prices are different",BigDecimal.valueOf(1.2),offers.buyOneGetOneFree(3, 0.60));
		assertEquals("expected and actual prices are different",BigDecimal.valueOf(0.5),offers.buyOneGetOneFree(4, 0.25));
	}
	
	@Test
	public void testForBuyOneGetOneFreeWithInvalidValues() {
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.buyOneGetOneFree(3, -0.60));
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.buyOneGetOneFree(4, 0.0));
	}
	
	@Test
	public void testForPriceOfThreeForTwo() {
		assertEquals("expected and actual prices are different",BigDecimal.valueOf(2.4),offers.priceOfThreeforTwo(5, 0.60));
		assertEquals("expected and actual prices are different",BigDecimal.valueOf(1.0),offers.priceOfThreeforTwo(6, 0.25));
	}
	
	@Test
	public void testForPriceOfThreeForTwoWithInvalidValues() {
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.priceOfThreeforTwo(5, 0.0));
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.priceOfThreeforTwo(6, -0.25));
	}
	
	@Test(expected=NullPointerException.class)
	public void testFindOfferForFruitsNullPointerException() {
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.findOfferForFruits(null,5, 0.0));
	}
	
	@Test
	public void testFindOfferForFruitsEmptyValue() {
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.findOfferForFruits("",5, 0.0));
	}
	
	@Test
	public void testFindOfferForFruitsApple() {
		assertEquals("expected and actual prices are different",BigDecimal.valueOf(1.8),offers.findOfferForFruits("Apple",5, 0.60));
		
		// It's assumed the fruit name is case sensitive
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.findOfferForFruits("apple",5, 0.60));
	}

	@Test
	public void testFindOfferForFruitsOrange() {
		assertEquals("expected and actual prices are different",BigDecimal.valueOf(0.75),offers.findOfferForFruits("Orange",4, 0.25));
		
		// It's assumed the fruit name is case sensitive
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.findOfferForFruits("orange",4, 0.25));
	}

	
	@Test
	public void testFindOfferForFruitsDefault() {
		assertEquals("expected and actual prices are different",BigDecimal.ZERO,offers.findOfferForFruits("Banana",5, 0.60));
	}





}
