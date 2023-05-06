package leetcode.editor.cn;

//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。 
// void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 
//capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // 返回 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // 返回 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// 最多调用 2 * 10⁵ 次 get 和 put 方法 
// 
//
// Related Topics设计 | 哈希表 | 链表 | 双向链表 
//
// 👍 626, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LFU 缓存
 *
 * @author hsfxuebao
 * 2023-01-14 17:07:29 
 */
class P460_LfuCache{
    public static void main(String[] args) {
//        LFUCache solution = new P460_LfuCache().new LFUCache();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

        // key2val 的映射   kv
        private Map<Integer, Integer> keyToVal;
        // key2freq key对应频率的映射  kf表
        private Map<Integer, Integer> keyToFreq;

        // freq 对应的key的表  fk表
        private Map<Integer, LinkedHashSet<Integer>> freqToKeys;

        // 最小频率
        private int minFreq;

        // 容量
        private int cap;


        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            minFreq = 0;
            cap = capacity;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) {
                return -1;
            }
            // 提高key 的频率
            increaseFreq(key);
            return keyToVal.get(key);

        }


        public void put(int key, int value) {
            // key 存在，修改value的值 ，提高key频率
            if (keyToVal.containsKey(key)) {
                // 提高key的频率
                increaseFreq(key);
                // 更改 key对应的value值
                keyToVal.put(key, value);
                return;
            }
            // key 不存在 增加key
            if (keyToVal.size() >= cap) {
                // 删除访问频率最小的key
                removeMinFreqKey();
            }
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            this.minFreq = 1;
        }

        /**
         * 删除最少访问的元素
         */
        private void removeMinFreqKey() {
            LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(this.minFreq);
            Integer deletedKey = minFreqKeys.iterator().next();
            keyToVal.remove(deletedKey);
            keyToFreq.remove(deletedKey);
            minFreqKeys.remove(deletedKey);
            if (minFreqKeys.isEmpty()) {
                freqToKeys.remove(this.minFreq);
            }
        }



        /**
         * 增加 key 对应的 freq
         */
        private void increaseFreq(int key) {

            Integer oldFreq = keyToFreq.get(key);
            keyToFreq.put(key, oldFreq+1);

            // 删除oldFreq 对应的key
            LinkedHashSet<Integer> oldFreqKeys = freqToKeys.get(oldFreq);
            oldFreqKeys.remove(key);
            if (oldFreqKeys.isEmpty()) {
                freqToKeys.remove(oldFreq);
                if (this.minFreq == oldFreq) {
                    minFreq++;
                }
            }
            freqToKeys.putIfAbsent(oldFreq + 1, new LinkedHashSet<>());
            freqToKeys.get(oldFreq+1).add(key);
        }


}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
