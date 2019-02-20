package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sophie on 2019/2/20.
 * LintCode: 386. Longest Substring with At Most K Distinct Characters
 * https://www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters/description
 * https://leetcode.com/articles/longest-substring-with-at-most-two-distinct-charac/
 */
public class LongestSubstringKMostDistinct {

    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here

        int max = 0;
        Map<Character, Integer> dist = new HashMap();

        int i = 0;
        int j = 0;

        while(i < s.length() && j < s.length()) {
            if(!dist.containsKey(s.charAt(j))) {
                dist.put(s.charAt(j), 1);
            }else {
                dist.put(s.charAt(j), dist.get(s.charAt(j))+1);
            }
            j++;
            while(dist.size() > k) {
                //当dist的size比k大的时候,意味着我们用到的不同的字母已经超过k个了
                //这个时候我们就不断地从开头减字母, 直到字母数又回到k个为止
                dist.put(s.charAt(i), dist.get(s.charAt(i))-1);
                if(dist.get(s.charAt(i)) == 0) {
                    dist.remove(s.charAt(i));
                }
                i++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}
