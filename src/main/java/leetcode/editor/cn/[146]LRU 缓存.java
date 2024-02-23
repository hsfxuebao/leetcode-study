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
// 👍 3041, 👎 0 
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
 * 2023-12-25 20:14:18 
 */
class P146_LruCache{
    public static void main(String[] args) {

    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

        DoubleNode cache;
        Map<Integer, Node> map = new HashMap<>();
        int cap;
        public LRUCache(int cap) {
            cache = new DoubleNode();
            this.cap = cap;
        }

        //
        public int get(int key) {
            if (map.containsKey(key)) {

                // 更新位置
                updateNode(key);

                return map.get(key).value;
            }
            return -1;
        }

        private void updateNode(int key) {
            Node node = map.get(key);
            cache.removeNode(node);
            cache.addLastNode(node);
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {
                // 删除节点
                removeNode(key);
                addNode(key, value);
                return;
            }

            if (cache.size >= cap) {
                // 删除节点
                remodeRecentlyNode();
            }

            // 添加节点
            addNode(key, value);
        }

        private void removeNode(int key) {
            Node node = map.get(key);
            cache.removeNode(node);
            map.remove(key);


        }

        private void remodeRecentlyNode() {
            Node node = cache.removeFirstNode();
            map.remove(node.key);
        }

        private void addNode(int key, int value) {
            Node node = new Node(key, value);
            map.put(key, node);
            cache.addLastNode(node);
        }


    }

    class DoubleNode{

        int size;
        Node head;
        Node tail;

        public DoubleNode(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            this.head.next = tail;
            this.tail.pre = head;
            size = 0;
        }


        // 末尾添加节点
        public void addLastNode(Node node) {
            node.pre = this.tail.pre;
            node.next = this.tail;
            this.tail.pre.next = node;
            this.tail.pre = node;
            size++;
        }
        // 删除一个节点
        public void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        // 删除头节点
        public Node removeFirstNode(){

            Node node = this.head.next;
            removeNode(node);
            return node;
        }


    }

 class Node {

        int key, value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
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
