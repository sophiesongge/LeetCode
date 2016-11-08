import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * 题目：https://leetcode.com/problems/sort-characters-by-frequency/
 * 备注：经典的优先级队列题（PriorityQueue）
 * @author Sophie
 */

public class SortCharacterByFrequency {
	
	public static void main(String[] args){
		System.out.println(frequencySort("ababac"));
	}
	
    static class letterEntry{
        char c;
        int frequency;
        public letterEntry(char c, int frequency){
            this.c = c;
            this.frequency = frequency;
        }
    }
    
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(Character c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
        }
        
        
        
        Comparator<letterEntry> cmp;
        cmp = new Comparator<letterEntry>(){
            public int compare(letterEntry l1, letterEntry l2){
                return l2.frequency - l1.frequency;
            }
        };
        
        Queue<letterEntry> queue = new PriorityQueue(cmp);
        
        for(Character c : map.keySet()){
            letterEntry lf = new letterEntry(c, map.get(c));
            queue.add(lf);
        }
        
        StringBuffer sb = new StringBuffer();
        
        while(!queue.isEmpty()){
        	letterEntry le = queue.poll();
        	for(int i=0; i<le.frequency; i++){
        		sb.append(le.c);
        	}
        }
        
        return sb.toString();
    }
}