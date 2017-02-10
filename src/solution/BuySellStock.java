/**
 * @author Sophie Song
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
package solution;

public class BuySellStock {
	
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
	
	public int maxProfit0(int[] prices) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		
		int len = prices.length;
		int[] dp = new int[len+1];
		dp[0] = 0;
		dp[1] = 0;
		
		int min = prices[0];
		int max = 0;
		
		for(int i=2; i<=len; i++){			
			if(prices[i-1] < min){
				min = prices[i-1];
			}
			if(prices[i-1] - min > max){
				dp[i] = prices[i-1] - min;
				max = dp[i];
			}else{
				dp[i] = max;
			}
		}
		
		return dp[len];
	}
}
