package solution;

import java.util.HashMap;
import java.util.Map;

public class CanIWin{
	Map<Integer, Boolean> map;
	boolean[] used;
	
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(desiredTotal > sum){
            return false;
        }
        if(desiredTotal <= 0){
            return true;
        }
        map = new HashMap();
        used = new boolean[maxChoosableInteger+1];
        return helper(desiredTotal);
    }
    
    public boolean helper(int desiredTotal){
    	if(desiredTotal <= 0){
    		return false;
    	}
    	int mapkey = format(used);
    	if(!map.containsKey(mapkey)){
    		for(int i=1; i<used.length; i++){
    			used[i] = true;
    			if(!helper(desiredTotal - i)){
    				map.put(mapkey, true);
    				used[i] = false;
    				return true;
    			}
    			used[i] = false;
    		}
    		map.put(mapkey, false);
    	}
    	return map.get(mapkey);
    }
    
    public int format(boolean[] used){
    	int num = 0;
    	for(boolean b : used){
    		num <<= 1;
    		if(b) {
    			num |= 1;
    		}
    	}
    	return num;
    }
}