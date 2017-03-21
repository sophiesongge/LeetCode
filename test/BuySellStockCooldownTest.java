import static org.junit.Assert.*;

import org.junit.Test;

import solution.BuySellStockCooldown;

public class BuySellStockCooldownTest {
	BuySellStockCooldown bss = new BuySellStockCooldown();
	
	@Test
	public void buySellStockCooldownTest() {
		int[] prices = null;
		assertEquals(0, bss.maxProfit(prices));
		prices = new int[]{1, 2, 3, 0, 2};
		assertEquals(3, bss.maxProfit(prices));
		
		prices = new int[]{1, 2, 4};
		assertEquals(3, bss.maxProfit(prices));
		
		prices = new int[]{1,4,2};
		assertEquals(3, bss.maxProfit(prices));;
		
		prices = new int[]{2,1,2,0,1};
		assertEquals(1, bss.maxProfit(prices));
	}
}
