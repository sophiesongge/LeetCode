package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sophie on 2019/2/20.
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
class LongestSubstringKLeastRepeat {
    public static void main(String[] args) {
        LongestSubstringKLeastRepeat test = new LongestSubstringKLeastRepeat();
        System.out.println("The answer for \"aaabbbcc 3\" is: " + test.longestSubstring("aaabbbcc", 3));
    }

    public int longestSubstring(String s, int k) {
        int max = 0;
        for(int u=1; u<=26; u++) {
            //u is the number of unique letters that is allowed to use
            int i = 0;
            int j = 0;
            int uni = 0; // uni is the number of unique letters in the sliding window (i, j)
            int moreThanK = 0; //moreThanK is the number of letters that appear more than k times
            Map<Character, Integer> map = new HashMap();
            while(j < s.length()) {
                char jj = s.charAt(j);
                if(uni <= u) {
                    if(!map.containsKey(jj)) {
                        map.put(jj, 1);
                    }else{
                        map.put(jj, map.get(jj) + 1);
                    }
                    if(map.get(jj) == 1) {
                        uni++;
                    }
                    if(map.get(jj) == k) {
                        moreThanK++;
                    }
                    j++;
                }else{
                    //in this case the number of unique letters exceeds the number of unique letters that is allowed to use,
                    // so we remove one letter from the begin by sliding i forward.
                    char ii = s.charAt(i);
                    if(map.get(ii) == k) {
                        moreThanK--;
                    }
                    if(map.get(ii) == 1) {
                        uni--;
                    }
                    map.put(ii, map.get(ii) - 1);
                    i++;
                }
                if(uni == u && uni == moreThanK) {
                    //if in this substring, the number of unique letters equals to the number of unique letters that is allowed to use,
                    // and at the same time these letters all appear more than k times (which means that the number of unique letters
                    // equals to the number of letters that appear more than k times --> at this time we get the longest substring
                    // that we can get with the allowed number of unique letters)
                    max = Math.max(max, j - i);//here we don't need to use j - i + 1, because we already roll j to j++
                }
            }
        }
        return max;
    }
}
