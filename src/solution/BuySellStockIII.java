/**
 * @author Sophie
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 这道题还是比较难，虽然代码不多，我一开始用优先级队列做的，后来想想其实不对，因为不可能把所有情况都算到。
 * 正确的思路是使用“局部最优和全局最优”的思想 --- 和cooldown那个很像， 利用两个动态规划数组local和global。 其中global[i][j]表示到第i天最多进行j次交易可以达到的最大利润，
 * 而local[i][j]表示到第i天最多进行j次交易，并且在第i天卖出可以达到的最大利润。
 * 则： global[i][j] = Math.max(local[i][j], global[i-1][j]) 也就是到今天为止的全局最好，是到今天为止的局部最好与到昨天的全局最好中大的那个
 * 因为今天的最大利润有两种情况，第一是几天卖出了（既local[i][j]），另一种是今天什么都没做，那今天的最好的情况就是昨天的全局最好情况
 * 而： local[i][j] = Math.max(global[i-1][j-1] + prices[i] - prices[i-1], local[i-1][j-1] + prices[i] - prices[i-1])
 * 这里就不太好理解了， 因为今天需要卖出，所以需要加prices[i] - prices[i-1], 两种加的可能性，（1） 和全局比，（2）和局部比
 */

package solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BuySellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
        	return 0;
        }
        
        int[] local = new int[3];
        int[] global = new int[3];
        
        local[0] = 0;
        global[0] = 0;
        
        for(int i=1; i<prices.length; i++) {
        	int profitToday = prices[i] - prices[i-1];
        	for(int j = 2; j>=1; j--) {
        		local[j] = Math.max(global[j-1] + profitToday, local[j] + profitToday);
        		global[j] = Math.max(local[j], global[j]);
        	}
        }
    	return global[2];
    }

}
