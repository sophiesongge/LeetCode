package solution;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderI{
	
	public static void main(String[] args){
		String start = "hit";
		String end = "cog";
		
		Set<String> dict = new HashSet();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		WordLadderI test = new WordLadderI();
		System.out.println(test.wordLadder(start, end, dict));
	}
	
	public String replace(String word, int index, char c){
		char[] wordArray = word.toCharArray();
		wordArray[index] = c;
		return new String(wordArray);
	}
	
	public ArrayList<String> getAdjacent(String word, Set<String> dict){
		ArrayList<String> adjacent = new ArrayList();
		int len = word.length();
		for(char letter = 'a'; letter <= 'z'; letter++){
			for(int i=0; i<len; i++){
				if(word.charAt(i)!=letter){
					if(dict.contains(replace(word, i, letter))){
						adjacent.add(replace(word, i, letter));
					}
				}
			}
		}
		return adjacent;
	}
	
	public int wordLadder(String start, String end, Set<String> dict){
		if(dict == null || dict.size() == 0){
			return 0;
		}
		if(start.equals(end)){
			return 1;
		}
		int length = 1;
		dict.add(start);
		dict.add(end);
		
		Queue<String> q = new LinkedList();
		Queue<String> visited = new LinkedList();
		
		q.add(start);
		visited.add(start);
		
		while(!q.isEmpty()){
			length++;
			int size = q.size();
			for(int i=0; i<size; i++){
				String top = q.poll();
				for(String adj : getAdjacent(top, dict)){
					if(visited.contains(adj)){
						continue;
					}else if(adj.equals(end)){
						return length;
					}else{
						visited.add(adj);
						q.add(adj);
					}
				}
			}
		}
		return 0;
	}
	
}