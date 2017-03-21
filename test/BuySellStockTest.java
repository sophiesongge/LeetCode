package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.BuySellStock;

public class BuySellStockTest {
	BuySellStock bss = new BuySellStock();
	
	@Test
	public void buySellStockTest() {
		int[] prices = null;
		assertEquals(0, bss.maxProfit(prices));
		prices = new int[]{10, 1, 2, 3, 8, 9, 4, 5};
		assertEquals(8, bss.maxProfit(prices));
	}
}
