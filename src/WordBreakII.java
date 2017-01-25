import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
		
		toString(wordBreakBacktracing(s, dict));
	}

	/**
	 * 这个是Backtracing的方法，结果是对的，问题是s如果是很多个a的情况会有TLE，单机测试了一下，回溯确实是很耗时，所以实际应用中必须要剪枝，否自就是个toy
	 * 这道题剪枝的方式其实是利用了WordBreakI，来体现先判断一下s能不能被wordDict中的单词分解 --- 其实这也是个不错的方法， 简单易懂， 但是确实是比后面那个耗时很多
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public static List<String> wordBreakBacktracing(String s, List<String> wordDict){
		List<String> res = new ArrayList();
		StringBuffer temps = new StringBuffer();
		backtracing(res, temps, s, wordDict);
		return res;
	}
	private static void backtracing(List<String> res, StringBuffer temps, String s, List<String> wordDict){
		//剪枝：利用wordbreakI来提前判断一下s是否能被wordDict里面的词分解，如果不行直接pass，聪明聪明！
		if(!isBreakable(s, wordDict)){
			return; 
		}
		
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
	
	public static boolean isBreakable(String s, List<String> dict){
		if(s == null){
			return false;
		}
		
		int len = s.length();
		
		boolean[] dp = new boolean[len + 1];
		
		dp[0] = true;
		for(int i=1; i<=len; i++){
			for(int j=0; j<i; j++){
				if(dp[j] && dict.contains(s.substring(j,i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}

	
	/**
	 * 这个方法叫DFS，它的思想正好跟回溯返过来，回溯看s的substring是否在wordDict中，这个方法是遍历wordDict中的词，看其是否能将s分解
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public static List<String> wordBreak(String s, List<String> wordDict){
		HashMap<String, LinkedList<String>> graph = new HashMap();
		return DFS(s, wordDict, graph);
	}
	
	private static List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> graph){
		if(graph.containsKey(s)){
			return graph.get(s);
		}
		
		LinkedList res = new LinkedList();
		
		if(s.length() == 0){
			res.add("");
			return res;
		}
		
		for(String word : wordDict){
			if(s.startsWith(word)){
				List<String> rest = DFS(s.substring(word.length()), wordDict, graph);
				for(String w : rest){
					word = word + " " + w;
					res.add(word.trim());
				}
			}
		}
		graph.put(s, res);
		return res;
	}

	
	public static void toString(List<String> res){
		for(int i=0; i<res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}
