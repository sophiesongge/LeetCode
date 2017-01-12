import java.util.ArrayList;
import java.util.HashMap;

public class GetRandom {
	
	ArrayList<Integer> numbers;
	HashMap<Integer, Integer> locations;
	java.util.Random random = new java.util.Random();
	
	public GetRandom(){
		this.numbers = new ArrayList();
		this.locations = new HashMap();
	}
	
	public boolean insert(int val){
		if(numbers.contains(val)){
			return false;
		}else{
			numbers.add(val);
			locations.put(val, numbers.size()-1);
			return true;
		}
	}
	
	public boolean remove(int val){
		if(!numbers.contains(val)){
			return false;
		}else{
			int last = numbers.get(numbers.size() - 1);
			int loc = locations.get(val);
			numbers.set(loc, last);
			locations.put(last, loc);
			numbers.remove(numbers.size()-1);
			locations.remove(val);
			return true;
		}
	}
	
	public int getRandom(){
		return numbers.get(random.nextInt(numbers.size()));
	}
	
}