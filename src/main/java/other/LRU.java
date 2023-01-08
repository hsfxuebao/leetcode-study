package other;

import java.util.LinkedHashMap;
import java.util.Map.Entry;


/**
 * @author HSFXUEBAO
 * Created on 2023-01-08
 * 使用LinkedHashMap 实现
 */
public class LRU extends LinkedHashMap<Integer, Integer>{

    int capacity;
    public LRU(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        final LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        System.out.println(lru);
        lru.put(3, 3);
        System.out.println(lru);
    }
}
