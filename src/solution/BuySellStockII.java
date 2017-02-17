/**
 * @author Sophie Song
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 * 这道题相对简单，不要把自己绕进去，其实只要比较是不是今天比昨天贵， 不用管之前的情况，
 * 举个简单的栗子，比如考虑第三天的情况的时候， 因为day3 - day1 = day3 - day2 + day2 - day1, 而day2 - day1 又已经包含在dp[day2]中
 * 所以，只要day3比day2大，则，dp[day3] = dp[day2] + day3 - day2
 */
package solution;

public class BuySellStockII {
	//贪心
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <=1) {
			return 0;
		}
		
		int len = prices.length;
		int profit = 0;
		
		for(int i=2; i<=len; i++){
			profit = Math.max(profit, profit + prices[i-1] - prices[i-2]);
		}
		
		return profit;
	}
	
	//动态规划
    public int maxProfit0(int[] prices) {
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
