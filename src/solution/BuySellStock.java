/**
 * @author Sophie Song
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
package solution;

public class BuySellStock {
	
	//贪心
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		int len = prices.length;
		int min = prices[0];
		int max = 0;
		
		for(int i=2; i<=len; i++){
			min = Math.min(min, prices[i-1]);
			max = Math.max(max, prices[i-1] - min);
		}
		return max;
	}
	
	//动态规划
	public int maxProfit0(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int len = prices.length;
        int[] dp = new int[len+1];
        
        int min = prices[0];
        
        for(int i=2; i<=len; i++) {
            min = Math.min(min, prices[i-1]);
            dp[i] = Math.max(dp[i-1], prices[i-1] - min);
        }
        return dp[len];
	}
}
