import java.util.*;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {
    Map<Integer, Integer> map;
    int size;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        size = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > size) {
            for (Integer k : map.keySet()) {
                map.remove(k);
                break;
            }
        }
    }
}