package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sophie Song
 * @since 22/06/2017
 */
public class FIFOCache {

    Map<Integer, NodeF> map;
    NodeF head;
    NodeF tail;
    int capacity;

    public FIFOCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new NodeF(0, 0);
        this.tail = new NodeF(0, 0);
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public int getElement(int key){
        if(map.containsKey(key)){
            int res = map.get(key).value;
            return res;
        }else{
            return -1;
        }
    }

    public void deleteNode(NodeF node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(NodeF node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void addElement(int key, int value){
        if(map.containsKey(key)){
            NodeF cur = map.get(key);
            cur.value = value;
            map.put(key, cur);
        }else{
            if(map.size() < capacity){
                NodeF nn = new NodeF(key, value);
                map.put(key, nn);
                addToHead(nn);
            }else{
                //delete tail.pre
                NodeF x = tail.pre;
                map.remove(x.key);
                deleteNode(tail.pre);
                NodeF nn = new NodeF(key, value);
                addToHead(nn);
                map.put(key, nn);
            }
        }
    }

    public static void main(String[] args){
        FIFOCache test = new FIFOCache(5);
        test.addElement(1, 1);
        test.addElement(2, 2);
        test.addElement(3, 3);
        System.out.println(test.getElement(1));
        test.addElement(4, 4);
        test.addElement(5, 5);
        System.out.println(test.getElement(1));
        test.addElement(6, 6);
        System.out.println(test.getElement(1));
    }

}

class NodeF{
    int key;
    int value;
    NodeF pre;
    NodeF next;

    public NodeF(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


