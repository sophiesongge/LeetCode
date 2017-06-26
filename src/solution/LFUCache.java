package solution;



import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
    public int capacity;
    private Map<Integer, LFUNode> map;
    private PriorityQueue<LFUNode> queue;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        Comparator<LFUNode> cmp = new Comparator<LFUNode>() {
            @Override
            public int compare(LFUNode o1, LFUNode o2) {
                if(o1.frequency != o2.frequency){
                    return o1.frequency - o2.frequency;
                }else{
                    return (int) ((int) o1.timestamp - o2.timestamp)*10000000;
                }



            }
        };
        this.queue = new PriorityQueue<>(10, cmp);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LFUNode n = map.get(key);
            queue.remove(n);
            n.frequency++;
            n.timestamp = System.currentTimeMillis();
            map.put(key, n);
            queue.add(n);
            return n.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            LFUNode n = map.get(key);
            queue.remove(n);
            n.value = value;
            n.frequency++;
            n.timestamp = System.currentTimeMillis();
            map.put(key, n);
            queue.add(n);
        }else{
            LFUNode n = new LFUNode(key, value);
            if(map.size() < capacity) {
                map.put(key, n);
                queue.add(n);
            }else{
                if(capacity == 0){
                    return;
                }else{
                    LFUNode last = queue.poll();
                    map.remove(last.key);
                    map.put(key, n);
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args){
        LFUCache lfu = new LFUCache(3);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.put(4, 4);
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        lfu.put(5, 5);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(5));
    }
}

class LFUNode{
    int key;
    int value;
    int frequency;
    long timestamp;

    public LFUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
        this.timestamp = System.currentTimeMillis();
    }
}