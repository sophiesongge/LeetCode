package solution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII{
	
	public static void main(String[] args){
		String start = "hit";
		String end = "cog";
		
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		WordLadderII test = new WordLadderII();
		
		List<List<String>> result = test.wordLadderII(start, end, dict);
		
		for(int i=0; i<result.size(); i++){
			for(int j=0; j<result.get(i).size(); j++){
				System.out.println(result.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
		
	}
	
	public String replace(String word, int i, char c){
		char[] wordArray = word.toCharArray();
		wordArray[i] = c;
		return new String(wordArray);
	}
	
	public ArrayList<String> getAdjacent(String word, Set<String> dict){
		ArrayList<String> adjacent = new ArrayList<String>();
		if(dict == null || dict.size() == 0){
			return adjacent;
		}
		int len = word.length();
		for(char c = 'a'; c <='z'; c++){
			for(int i=0; i<len; i++){
				if(word.charAt(i)!=c){
					if(dict.contains(replace(word, i, c))){
						adjacent.add(replace(word, i, c));
					}
				}
			}
		}
		return adjacent;
	}

	
	public void wordLadderHelper(String start, String end, Set<String> dict, Map<String, ArrayList<String>> graph, Map<String, Integer> distance){
		Queue<String> q = new LinkedList<String>();
		q.add(start);
		distance.put(start, 0);
		
		for(String s : dict){
			graph.put(s, new ArrayList<String>());
		}
		
		while(!q.isEmpty()){
			String current = q.poll();
			ArrayList<String> adjList = getAdjacent(current, dict);
			
			for(String adj : adjList){
				graph.get(adj).add(current);
				if(!distance.containsKey(adj)){
					distance.put(adj, distance.get(current)+1);
					q.add(adj);
				}
			}
			
		}
	}	
	
	
	public void backtracing(List<List<String>> result, List<String> temps, String start, String current, 
			Map<String, Integer> distance, Map<String, ArrayList<String>> graph){
		
		temps.add(current);
		
		if(current.equals(start)){
			Collections.reverse(temps);
			result.add(new ArrayList<String>(temps));
			Collections.reverse(temps);
		}else{
			for(String adj : graph.get(current)){
				if(distance.containsKey(adj) && distance.get(current) == distance.get(adj)+1){
					backtracing(result, temps, start, adj, distance, graph);
				}
			}
		}

		temps.remove(temps.size() - 1);
	}
		
	
	public List<List<String>> wordLadderII(String start, String end, Set<String> dict){
		List<List<String>> result = new ArrayList<List<String>>();
		if(dict == null || dict.size() == 0){
			return result;
		}
		Map<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();
		
		dict.add(start);
		dict.add(end);
		
		wordLadderHelper(start, end, dict, graph, distance);
		
		List<String> temps = new ArrayList<String>();
		
		backtracing(result, temps, start, end, distance, graph);
		
		return result;
	}
	
}