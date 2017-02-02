package solution;
/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * @author Sophie
 *
 */

import java.util.ArrayList;
import java.util.HashMap;



public class InsertDeleteRandom {
	ArrayList<Integer> numbers;
	HashMap<Integer, Integer> locations;
	java.util.Random random = new java.util.Random();
	

    /** Initialize your data structure here. */
    public InsertDeleteRandom() {
        this.numbers = new ArrayList();
        this.locations = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(numbers.contains(val)){
        	return false;
        }else{
        	numbers.add(val);
        	locations.put(val, numbers.size() - 1);
        	return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!numbers.contains(val)){
    		return false;
    	}else{
    		int last = numbers.get(numbers.size() - 1);
    		int loc = locations.get(val);
    		numbers.add(loc, last);
    		locations.put(last, loc);
    		numbers.remove(numbers.size() - 1);
    		locations.remove(val);
    		return true;
    	}
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()-1));
    }
	
	
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * InsertDeleteRandom obj = new InsertDeleteRandom();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */