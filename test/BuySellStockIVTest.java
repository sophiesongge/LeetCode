import static org.junit.Assert.*;

import org.junit.Test;

import solution.BuySellStockIV;
import solution.BuySellStockIII;

public class BuySellStockIVTest {
	BuySellStockIV bss = new BuySellStockIV();
	BuySellStockIII std = new BuySellStockIII();
	
	@Test
	public void testBuySellStockIV() {
		int[] prices = null;
		assertEquals(0, bss.maxProfit(2, prices));
		
		prices = new int[]{6,1,3,2,4,7};
		
		assertEquals(std.maxProfit(prices), bss.maxProfit(2, prices));
		
		assertEquals(bss.maxProfit(2, prices), bss.maxProfit0(2, prices));
	}

}
