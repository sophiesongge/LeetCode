package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.BuySellStockII;

public class BuySellStockIITest {
	BuySellStockII bss = new BuySellStockII();
	
	@Test
	public void buySellStockIITest() {
		int[] prices = null;
		assertEquals(0, bss.maxProfit(prices));
		
		prices = new int[]{4, 11, 100};
		
		assertEquals(96, bss.maxProfit(prices));
	}
}
