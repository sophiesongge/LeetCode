/**
 * @author Sophie Song
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?tab=Description
 * 这道题相对简单，因为一天可以多次买卖，如果限定一天只能买一次或卖一次就难了
 */
package solution;

public class BuySellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        
        int len = prices.length;
        int[] dp = new int[len+1];
        
        dp[0] = 0;
        dp[1] = 0;   

        for(int i=2; i<=len; i++) {
        	if(prices[i-1] > prices[i-2]){
        		dp[i] = dp[i-1] + prices[i-1] - prices[i-2]; 
        	}else{
        		dp[i] = dp[i-1];
        	}
        }
        
        return dp[len];
    }
}
