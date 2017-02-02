package solution;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * 题目：https://leetcode.com/problems/ransom-note/
 * 备注：经典的两个String题，用HashMap做
 * 		另外一个解法是用一个26个字母的array，每次把相应字母的位置++、--，相应字母的位置用charAt(i)-'a'来决定
 * @author Sophie
 */
public class RansomNote {
	
	public static void main(String[] args){
		System.out.println(canConstructII("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
		System.out.println(canConstructII("a", "aa"));
		System.out.println(canConstructII("aaa","aa"));
	}
	
	public static boolean canConstructII(String ransomNote, String magazine){
		int[] array = new int[26];
		for(char c : magazine.toCharArray()){
			array[c-'a']++;
		}
		for(char c : ransomNote.toCharArray()){
			if(--array[c-'a']<0){
				return false;
			}
		}
		return true;
	}
	
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap();
        for(Character c : magazine.toCharArray()){
        	if(!map.containsKey(c)){
        		map.put(c, 1);
        	}else{
        		map.put(c, map.get(c)+1);
        	}
        }
        for(Character c : ransomNote.toCharArray()){
        	if(!map.containsKey(c)){
        		return false;
        	}else{
        		if(map.get(c)==0){
        			return false;
        		}else{
        			map.put(c, map.get(c)-1);
        		}
        	}
        }
        return true;
    }
}