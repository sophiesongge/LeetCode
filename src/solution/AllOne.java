/**
 * @author Sophie Song
 * https://leetcode.com/problems/all-oone-data-structure/#/description
 * 主要的思想是维护一个装着Bucket的list。每个Bucket里面是所有有相同count的key
 * 用head和tail来保证getMax和getMin的O(1)
 */
package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    //维护一个doubly linked list
    private Bucket head;
    private Bucket tail;
    private Map<Integer, Bucket> countBucketMap; //以O(1)来接入某个指定的Bucket
    private Map<String, Integer> keyCountMap; //来追踪key的count

    /** Initialize your data structure here. */
    public AllOne() {
        this.head = new Bucket(Integer.MIN_VALUE);
        this.tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }

    //helpers
    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Bucket current = countBucketMap.get(count);
        Bucket newBucket;
        if(countBucketMap.containsKey(count+offset)){
            newBucket = countBucketMap.get(count+offset);
        }else{
            newBucket = new Bucket(count+offset);
            countBucketMap.put(count+offset, newBucket);
            addBucketAfter(newBucket, offset==1 ? current : current.pre);
        }
        newBucket.keySet.add(key);
        removeKeyFromBucket(current, key);
    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if(bucket.keySet.isEmpty()){
            removeBucketFromList(bucket);
            countBucketMap.remove(bucket.count);
        }
    }

    private void removeBucketFromList(Bucket bucket){
        bucket.pre.next = bucket.next;
        bucket.next.pre = bucket.pre;
        bucket.pre = null;
        bucket.next = null;
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket){
        newBucket.pre = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.pre = newBucket;
        preBucket.next = newBucket;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(keyCountMap.containsKey(key)){
            changeKey(key, 1);
        } else{
            keyCountMap.put(key, 1);
            if(head.next.count != 1){
                addBucketAfter(new Bucket(1), head);
            }
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keyCountMap.containsKey(key)){
            int count = keyCountMap.get(key);
            if(count == 1){
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            }else{
                changeKey(key, -1);
            }
        }

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "" : tail.pre.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("a");
        obj.inc("b");
        obj.inc("b");
        obj.inc("c");
        obj.inc("c");
        obj.inc("c");
        obj.dec("b");
        obj.dec("b");
        System.out.println(obj.getMinKey());
        obj.dec("a");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }
}

class Bucket{
    int count;
    Set<String> keySet;
    Bucket pre;
    Bucket next;
    public Bucket(int count){
        this.count = count;
        this.keySet = new HashSet<>();
    }

}