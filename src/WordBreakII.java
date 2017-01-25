import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break-ii/
 * @author Sophie
 *
 */
public class WordBreakII {
	
	public static void main(String[] args){
		String s = "catsanddog";
		List<String> dict = new ArrayList();
		dict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		
		String ss = "LeetCodes";
		List<String> dictt = new ArrayList();
		dictt.addAll(Arrays.asList("Leet", "Code", "Codes"));
		
		toString(wordBreak(ss, dictt));
	}

	
	public static List<String> wordBreak(String s, List<String> wordDict){
		List<String> res = new ArrayList();
		StringBuffer temps = new StringBuffer();
		backtracing(res, temps, s, wordDict);
		return res;
	}
	public static void backtracing(List<String> res, StringBuffer temps, String s, List<String> wordDict){

		for(int i=0; i<=s.length(); i++){
			if(wordDict.contains(s.substring(0, i))){
				int size = temps.length();
				temps.append(s.substring(0, i) + ' ');
				if(s.substring(i).length() == 0){
					res.add(String.valueOf(temps).trim());
					break;
				}
				backtracing(res, temps, s.substring(i), wordDict);
				if(size!=0){
					temps.delete(size-1, temps.length() - 1);
				}else{
					temps.delete(size, temps.length() - 1);
				}	
			}
		}
		
	}

	
	public static void toString(List<String> res){
		for(int i=0; i<res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}
