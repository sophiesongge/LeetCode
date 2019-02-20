package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sophie on 2019/2/20.
 * 3. Longest Substring Without Repeating Characters
 */
class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet();
        //check inside a sliding window (i, j), if there exist repeated letter, we just slide i forward
        while(i < s.length() && j < s.length()) {
            char jj = s.charAt(j);
            if(!set.contains(jj)) {
                set.add(jj);
                j++;
            }else {
                char ii = s.charAt(i);
                set.remove(ii);
                i++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}
