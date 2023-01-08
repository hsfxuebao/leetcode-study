package leetcode.editor.cn;

//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache1 类： 
//
// 
// 
// 
// LRUCache1(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache1", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache1 LRUCache1 = new LRUCache1(2);
//LRUCache1.put(1, 1); // 缓存是 {1=1}
//LRUCache1.put(2, 2); // 缓存是 {1=1, 2=2}
//LRUCache1.get(1);    // 返回 1
//LRUCache1.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//LRUCache1.get(2);    // 返回 -1 (未找到)
//LRUCache1.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//LRUCache1.get(1);    // 返回 -1 (未找到)
//LRUCache1.get(3);    // 返回 3
//LRUCache1.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 2510 👎 0

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * LRU 缓存
 *
 * @author hsfxuebao
 * 2023-01-08 08:24:53 
 */
class P146_LruCache{
    public static void main(String[] args) {
        LRUCache solution = new P146_LruCache().new LRUCache(2);
        solution.put(1, 1);
        solution.put(2, 2);
        System.out.println(solution.get(2));
        solution.put(3, 3);
        System.out.println(solution.get(2));


    }  
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 使用LinkedHashMap 实现
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {

        int capacity;
        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return new LRUCache(2).get(key);
        }

        public void put(int key, int value) {
            new LRUCache(2).put(key, value);

        }

        @Override
        protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

        /**
         * 使用双向链表+数组 实现
         */
        class LRUCache1 {

        DoubleList cache;
        Map<Integer, Node> map;
        int capacity;

    public LRUCache1(int capacity) {

        this.cache = new DoubleList();
        this.map = new HashMap<>();
        this.capacity = capacity;

    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
           return -1;
        }
        // 将该key提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            // 删除老的数据
            deleteKey(key);
            // 添加新的数据
            addRecently(key, value);
            return;
        }

        // 判断大小是否已经超过阈值
        if (cache.size >= capacity) {
            // 删除最近不使用的元素
            removeLeastRecently();
            // 添加新数据
            addRecently(key, value);
            return;
        }

        // 添加新的数据
        addRecently(key, value);
    }

        /* 将某个 key 提升为最近使用的 */
        private void makeRecently(int key) {
            Node node = map.get(key);
            // 链表中删除该节点
            cache.removeNode(node);
            // 添加到链表的最后边
            cache.addLast(node);
        }

        /* 添加最近使用的元素 */
        private void addRecently(int key, int val) {
            Node node = new Node(key, val);
            map.put(key, node);
            cache.addLast(node);
        }

        /* 删除某一个 key */
        private void deleteKey(int key) {
            final Node node = map.get(key);
            map.remove(key);
            cache.removeNode(node);
        }

        /* 删除最久未使用的元素 */
        private void removeLeastRecently() {
            Node node = cache.removeFirst();
            map.remove(node.key);
        }
}


    class Node {
         int key, val;
         Node pre, next;
         public Node(int key, int val) {
            this.key = key;
            this.val = val;
         }

    }

    /**
     * 尾部 是最新的数据
     */
    class DoubleList {

        // 头尾虚节点
        Node head, tail;
        // 链表总长度
        int size;

        public DoubleList() {
            // 初始化双向链表的数据
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        // 在尾部添加一个数据,时间o(1)
        public void addLast(Node node) {

            node.pre = tail.pre;
            node.next = tail;
            node.pre.next = node;
            tail.pre = node;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void removeNode(Node node) {
            Node pre = node.pre;
            pre.next = node.next;
            node.next.pre = pre;
            node.pre = null;
            node.next = null;
            size--;
        }
        // 删除链表中第一个节点，并返回该节点，时间 O(1)
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            removeNode(first);
            return first;
        }
        // 返回链表的大小 时间o(1)
        public int size() {
            return size;
        }

    }

/**
 * Your LRUCache1 object will be instantiated and called as such:
 * LRUCache1 obj = new LRUCache1(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
