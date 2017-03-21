import static org.junit.Assert.*;

import org.junit.Test;

import solution.BuySellStockIII;

public class BuySellStockIIITest {
	
	BuySellStockIII bss = new BuySellStockIII();
	
	@Test
	public void testBuySellStockIII(){
		int[] prices = new int[]{4, 2, 8, 7, 1, 6, 3, 5};
		prices = new int[]{1, 2};
		prices = new int[]{1, 4, 2};
		prices = new int[]{6,1,3,2,4,7};
		
		assertEquals(7, bss.maxProfit(prices));
		
		assertEquals(bss.maxProfit(prices), bss.maxProfit0(prices));
	}
	
}
