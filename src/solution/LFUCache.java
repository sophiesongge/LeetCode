package solution;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class Cache{
	int key;
	int frequency;
	int recent;
	public Cache(int k, int f, int r){
		this.key = k;
		this.frequency = f;
		this.recent = r;
	}
}

public class LFUCache {
    public int capacity;
    private HashMap<Integer, Integer> cache;
    private HashMap<Integer, Integer> frequency;
    private PriorityQueue<Integer> queue;
    
    public static void main(String[] args){
    	LFUCache lfu = new LFUCache(2);
    	System.out.println(lfu.get(1));
    	lfu.set(1, 1);
    	lfu.set(2, 2);
    	System.out.println(lfu.get(1));
    	lfu.set(3, 3);
    	System.out.println(lfu.get(1));
    	lfu.set(4, 4);
    	System.out.println(lfu.get(2));
    	System.out.println(lfu.get(3));
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();
        this.frequency = new HashMap();
        Comparator<Integer> cmp = new Comparator<Integer>(){
            public int compare(Integer e1, Integer e2){
            	if(frequency.containsKey(e1) && frequency.containsKey(e2)){
            		return frequency.get(e1) - frequency.get(e2);
            	}else{
            		return 0;
            	}
            }
        };
        this.queue = new PriorityQueue(10, cmp);
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            frequency.put(key, frequency.get(key) + 1);
            queue.add(key);
            return cache.get(key);
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            frequency.put(key, frequency.get(key)+1);
            queue.add(key);
        }else{
            if(cache.size() < capacity){
                cache.put(key, value);
                frequency.put(key, 1);
                queue.add(key);
            }else{
                int i = cache.size() - capacity;
                while(i >= 0){
                    cache.remove(queue.peek());
                    frequency.remove(queue.peek());
                    queue.poll();
                    i--;
                }
                cache.put(key, value);
                frequency.put(key, 1);
                queue.add(key);
            }
        }
    }
}