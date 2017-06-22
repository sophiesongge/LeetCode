package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sophie Song
 * @since 22/06/2017
 */
public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.pre = null;
        this.head.next = this.tail;
        this.tail.pre = this.head;
        this.tail.next = null;
    }

    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node current = map.get(key);
            int result = current.value;
            deleteNode(current);
            addToHead(current);
            map.put(key, current);
            return result;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node current = map.get(key);
            current.value = value;
            deleteNode(current);
            addToHead(current);
            map.put(key, current);
        }else{
            Node nn = new Node(key, value);
            if(map.size() < capacity){
                addToHead(nn);
                map.put(key, nn);
            }else{
                Node last = tail.pre;
                map.remove(last.key);
                deleteNode(tail.pre);
                addToHead(nn);
                map.put(key, nn);
            }
        }

    }
}


class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
