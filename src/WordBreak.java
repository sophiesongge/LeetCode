import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode.com/problems/word-break/
 * @author Sophie
 *
 */
public class WordBreak {
	
	public static void main(String[] args){
		String s = "LeetCode";
		List<String> wordDict = new ArrayList();
		wordDict.addAll(Arrays.asList("Leet", "Code"));
		System.out.println(wordBreak(s, wordDict));
	}
    
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for(int i=1; i<=s.length(); i++){
			for(int j=0; j<=i; j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
				}
			}
		}
		return dp[s.length()];
    }
}
