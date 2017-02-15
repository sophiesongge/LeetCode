package solution;
/**
 * @author Sophie
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 详细的想法见BuySellStockIII，还需要增加一点，如果k>n/2就要注意了，这时候可以转化为最简单的buy sell stock来做，不然会有TLE
 */

public class BuySellStockIV {
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		
		int len = prices.length;
		
		if(k > len/2) {
			int maxProfit = 0;
			for(int i=1; i<len; i++) {
				maxProfit = maxProfit + Math.max(0, prices[i] - prices[i-1]);
			}
			return maxProfit;
		}
		
		int[] local = new int[k+1];
		int[] global = new int[k+1];

		for(int i=1; i<len; i++) {
			int curProfit = prices[i] - prices[i-1];
			for(int j=k; j>=1; j--) {
				local[j] = Math.max(global[j-1] + curProfit, local[j] + curProfit);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];
	}
}
