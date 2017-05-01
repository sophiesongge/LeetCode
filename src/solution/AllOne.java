/**
 * @author Sophie Song
 * https://leetcode.com/problems/all-oone-data-structure/#/description
 */
package solution;

import java.util.HashMap;
import java.util.Map;

public class AllOne {
    Map<String, Integer> map;
    String[] keys;

    /** Initialize your data structure here. */
    public AllOne() {
        this.map = new HashMap();
        this.keys = new String[2];
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!map.containsKey(key)){
            map.put(key, 1);
        }else{
            map.put(key, map.get(key) + 1);
        }
        if(map.size() == 1) {
            keys[0] = key;
            keys[1] = key;
        }
        int max = map.get(keys[0]);
        int min = map.get(keys[1]);
        if(max < map.get(key)){
            keys[0] = key;
        }
        if(min > map.get(key)){
            keys[1] = key;
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            if(map.get(key) == 1){
                map.remove(key);
            }else{
                map.put(key, map.get(key) - 1);
            }
            if(!map.isEmpty()){
                int min = map.get(keys[1]);
                if(min >= map.get(key)){
                    keys[1] = key;
                }
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(map.isEmpty()) {
            return "";
        }
        return keys[0];
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(map.isEmpty()){
            return "";
        }
        return keys[1];
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
