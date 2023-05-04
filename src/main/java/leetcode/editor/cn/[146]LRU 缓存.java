package leetcode.editor.cn;

//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics设计 | 哈希表 | 链表 | 双向链表 
//
// 👍 2668, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @author hsfxuebao
 * 2023-05-04 15:08:27 
 */
class P146_LruCache{
    public static void main(String[] args) {
//        Solution solution = new P146_LruCache().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 使用双向链表+Map 实现
     */
class LRUCache {

        DoubleList cache;
        Map<Integer, Node> map;
        int capacity;

        public LRUCache(int capacity) {

            this.cache = new DoubleList();
            this.map = new HashMap<>();
            this.capacity = capacity;

        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            //
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            // map中已包含key
            if (map.containsKey(key)) {
                deleteKey(key);
            }
            // size 比较
            if (cache.size() >= this.capacity) {
                removeFirst();
            }
            addRecently(key, value);
        }


        /* 将某个 key 提升为最近使用的 */
        // key肯定在 链表中
        public void makeRecently(int key) {
            Node node = map.get(key);
            // 先从链表中删除这个节点
            cache.removeNode(node);
            // 再把该节点 加入到链表中
            cache.addLast(node);
        }

        // 添加一个元素
        public void addRecently(int key, int val) {
            Node node = new Node(key, val);
            cache.addLast(node);
            map.put(key, node);
        }


        // 删除 一个元素
        public void deleteKey(int key) {

            Node node = map.get(key);
            cache.removeNode(node);
            // map中也删除这个节点
            map.remove(key);
        }

        // 删除最不经常使用的元素
        public void removeFirst() {
            Node removeNode = cache.removeFirst();
            map.remove(removeNode.key);
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
            // size 链表元素数
            int size;

            public DoubleList() {
                this.head = new Node(0, 0);
                this.tail = new Node(0, 0);
                this.head.next = tail;
                this.tail.pre = head;
                this.size = 0;
            }

            // 在链表尾部添加节点 x，时间 O(1)
            public void addLast(Node x) {

                x.pre = this.tail.pre;
                x.next = this.tail;
                this.tail.pre.next = x;
                this.tail.pre = x;
                size++;
            }

            // 删除链表中的 x 节点（x 一定存在）
            // 由于是双链表且给的是目标 Node 节点，时间 O(1)
            public void removeNode(Node x) {
                x.next.pre = x.pre;
                x.pre.next = x.next;
                x.pre = null;
                x.next = null;
                size--;
            }

            // 删除最不经常使用的节点
            public Node removeFirst() {
                Node first = head.next;
                if (first == tail) {
                    return null;
                }
                removeNode(first);
                return first;
            }

            public int size() {
                return size;
            }

        }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
