/**
 * @author Sophie Song
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 很好的一道题， 很容易把自己绕乎进去。 
 * 每天都有两种可能性，要么卖，要么啥都不干。 当然这天的最大收益则是这两个方案中大的那个。 按照DP的思想，不如开两个数组，一个表示今天要卖，另一个表示今天啥也不干。
 * profitDoNothing[i]比较容易想，因为今天啥也不干，所以今天就继承昨天的结果，昨天的结果又有两种可能 --- 卖、啥也不干，当然要继承它俩中大的那个，所以
 * profitDoNothing[i] = Math.max(profitSell[i-1], profitDoNothing[i-1])。
 * 重点来了，profitSell[i]怎么算。其实也有两种情况，如果day[i-1]我买入了（或者卖了，因为卖完了可以再买回来），则day[i]可以直接卖，收益是:
 * profitSell[i] = profitSell[i-1] + prices[i] - prices[i-1]。但是还有一种情况，就是day[i-1]是啥也没干的，所以day[i]需要把自己先买回来，再卖，收益是：
 * profitSell[i] = profitDoNothing[i-1] + prices[i] - prices[i] = profitDoNothing[i-1]。最终取这两个大的就行了。
 * 
 * 其实这道题有个更简单的算法，是后面那个被我注释掉的。仔细看你的动态规划的状态转移方程，你会发现其实你不需要一个数组，你只需要两个数： profitSell & profitDoNothing
 * 然后每次比较的时候创建一个中间变量即可 --- 是不是很神奇呢
 */

package solution;

public class BuySellStockCooldown {
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		
		int len = prices.length;
		int[] profitSell = new int[len+1];
		int[] profitDoNothing = new int[len+1];
		
		profitSell[0] = 0;
		profitDoNothing[0] = 0;
		profitSell[1] = 0;
		profitDoNothing[1] = 0;
		
		for(int i=2; i<=len; i++) {
			profitSell[i] = Math.max(profitSell[i-1] + prices[i-1] - prices[i-2], profitDoNothing[i-1]);
			profitDoNothing[i] = Math.max(profitDoNothing[i-1], profitSell[i-1]);
		}
		
		return Math.max(profitSell[len], profitDoNothing[len]);
	}
	
	public int maxProfitBetter(int[] prices) {
	if(prices == null || prices.length <= 1){
		return 0;
	}
	
	int profitSell = 0;
	int profitDoNothing = 0;
	
	for(int i=1; i<prices.length; i++) {
		int temps = profitSell;
		profitSell = Math.max(profitSell + prices[i] - prices[i-1], profitDoNothing);
		profitDoNothing = Math.max(temps, profitDoNothing);
	}
	
	return Math.max(profitSell, profitDoNothing);
}
	
    
}
