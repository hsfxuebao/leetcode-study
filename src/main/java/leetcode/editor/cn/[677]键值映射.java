package leetcode.editor.cn;

//设计一个 map ，满足以下几点: 
//
// 
// 字符串表示键，整数表示值 
// 返回具有前缀等于给定字符串的键的值的总和 
// 
//
// 实现一个 MapSum 类： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 ke
//y 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // 返回 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // 返回 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 224 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 键值映射
 *
 * @author hsfxuebao
 * 2023-01-08 17:42:27 
 */
class P677_MapSumPairs{
    public static void main(String[] args) {
        MapSum solution = new P677_MapSumPairs().new MapSum();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class MapSum {

        TrieMap<Integer> map = new TrieMap<>();

    public MapSum() {

    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {


        List<String> preList = map.keysWithPrefix(prefix);
        int sum = 0;
        if (preList == null || preList.size() <= 0) {
            return sum;
        }
        for (String pre : preList) {
            Integer integer = map.get(pre);
            if (integer != null) {
                sum += integer;

            }
        }
        return sum;
    }
    
    
}

    class TrieMap<V> {

        // ASCII 码个数
        private static final int R = 256;
        // 当前存在 Map 中的键值对个数
        private int size = 0;

        public class TrieNode<V> {
            V val = null;
            TrieNode<V>[] children = new TrieNode[R];
        }

        // Trie 树的根节点
        private TrieNode<V> root = null;

        /* 其他 API 的实现... */

        // 搜索 key 对应的值，不存在则返回 null
        public V get(String key) {
            // 从 root 开始搜索 key
            TrieNode<V> node = getNode(root, key);
            // node 为空或 node 的 val 字段为空都说明 key 没有对应的值
            if (node != null && node.val != null) {
                return node.val;
            }
            return null;
        }

        // 判断 key 是否存在在 Map 中
        public boolean containsKey(String key) {
            return get(key) != null;
        }

        // 判断是和否存在前缀为 prefix 的键
        public boolean hasKeyWithPrefix(String prefix) {
            TrieNode<V> node = getNode(root, prefix);
            return node != null;
        }

        // 在所有键中寻找 query 的最短前缀
        // 类似getNode方法的逻辑，我们可以实现shortestPrefixOf方法，
        // 只要在第一次遇到存有val的节点的时候返回就行了：
        public String shortestPrefixOf(String query) {
            TrieNode p = root;
            // 从节点 node 开始搜索 key
            for (int i = 0; i < query.length(); i++) {
                // 无法向下搜索
                if (p == null) {
                    return "";
                }
                // 找到一个键是 query 的前缀
                if (p.val != null) {
                    return query.substring(0, i);
                }
                // 向下搜索
                p = p.children[query.charAt(i)];
            }
            // 如果 query 本身就是一个键
            if (p != null && p.val != null) {
                return query;
            }
            return "";
        }

        // 在所有键中寻找 query 的最长前缀
        public String longestPrefixOf(String query) {

            TrieNode p = root;
            int maxPreLen = 0;

            // 从root节点开始搜索
            for (int i = 0; i < query.length(); i++) {

                // 无法向下搜索
                if (p == null) {
                    return query.substring(0, maxPreLen);
                }
                // 找到一个前缀
                if (p.val != null) {
                    maxPreLen = Math.max(maxPreLen, i);
                }
                // 向下搜索
                p = p.children[query.charAt(i)];
            }

            if (p != null && p.val != null) {
                return query;
            }
            return query.substring(0, maxPreLen);
        }

        // 搜索前缀为 prefix 的所有键
        public List<String> keysWithPrefix(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode<V> node = getNode(root, prefix);
            if (node == null) {
                return res;
            }

            // DFS 遍历以 x 为根的这棵 Trie 树
            traverse(node, new StringBuilder(prefix), res);
            return res;
        }
        private void traverse(TrieNode root, StringBuilder path, List<String> res) {

            if (root == null) {
                // 到达 Trie 树底部叶子结点
                return;
            }
            if (root.val != null) {
                // 找到一个 key，添加到结果列表中
                res.add(path.toString());
            }

            // 回溯算法遍历框架
            TrieNode<V>[] children = root.children;
            for (char c = 0; c < R; c++) {
                // 做选择
                path.append(c);
                traverse(children[c], path, res);
                // 撤销选择
                path.deleteCharAt(path.length() - 1);
            }
        }

        // 通配符 . 匹配任意字符
        // 它们返回的结果列表一定是符合「字典序」的。
        public List<String> keysWithPattern(String pattern) {
            List<String> res = new LinkedList<>();
            traverse(root, new StringBuilder(), pattern, 0, res);
            return res;
        }
        private void traverse(TrieNode<V> root, StringBuilder path,
                String pattern, int i, List<String> res) {

            if (root == null) {
                return;
            }
            // 匹配完成
            if (i == pattern.length()) {
                if (root.val != null) {
                    res.add(path.toString());
                }
                return;
            }


            // 选择集
            char ch = pattern.charAt(i);
            TrieNode[] children = root.children;
            // 匹配通配符
            if ('.' == ch) {

                for (char c = 0; c < R; c++) {
                    // 做选择
                    path.append(c);
                    traverse(children[c], path, pattern, i+1, res);
                    // 撤销选择
                    path.deleteCharAt(path.length()-1);
                }

            } else {
                // 做选择
                path.append(ch);
                traverse(children[ch], path, pattern, i+1, res);
                path.deleteCharAt(path.length()-1);
            }
        }


        // 判断是和否存在通配符为 pattern 的键
        public boolean hasKeyWithPattern(String pattern) {
            // 从 root 节点开始匹配 pattern[0..]
            return hasKeyWithPattern(root, pattern, 0);
        }

        private boolean hasKeyWithPattern(TrieNode<V> root, String pattern, int i) {

            if (root == null) {
                return false;
            }
            // 匹配完成
            if (i == pattern.length()) {
                return true;
            }
            // 选择集
            char c = pattern.charAt(i);
            TrieNode[] children = root.children;
            // 匹配通配符
            if ('.' == c) {

                for (char j = 0; j < R; j++) {
                    return hasKeyWithPattern(children[j], pattern, i+1);
                }

            } else {
                return hasKeyWithPattern(children[c], pattern, i+1);
            }
            return false;
        }

        // 在 map 中添加或修改键值对
        public void put(String key, V val) {
            if (!containsKey(key)) {
                // 新增键值对
                size++;
            }
            // 需要一个额外的辅助函数，并接收其返回值
            root = put(root, key, val, 0);
        }
        // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
        private TrieNode<V> put(
                TrieNode<V> node, String key, V val, int i) {
            if (node == null) {
                // 如果树枝不存在，新建
                node = new TrieNode<>();
            }
            if (i == key.length()) {
                // key 的路径已插入完成，将值 val 存入节点
                node.val = val;
                return node;
            }
            char c = key.charAt(i);
            // 递归插入子节点，并接收返回值
            node.children[c] = put(node.children[c], key, val, i + 1);
            return node;
        }


        // 在 Map 中删除 key
        public void remove(String key) {
            if (!containsKey(key)) {
                return;
            }
            // 递归修改数据结构要接收函数的返回值
            root = remove(root, key, 0);
            size--;
        }

        // 定义：在以 node 为根的 Trie 树中删除 key[i..]，返回删除后的根节点
        private TrieNode<V> remove(
                TrieNode<V> node, String key, int i) {
            if (node == null) {
                return null;
            }
            if (i == key.length()) {
                // 找到了 key 对应的 TrieNode，删除 val
                node.val = null;
            } else {
                char c = key.charAt(i);
                // 递归去子树进行删除
                node.children[c] = remove(node.children[c], key, i + 1);
            }
            // 后序位置，递归路径上的节点可能需要被清理
            if (node.val != null) {
                // 如果该 TireNode 存储着 val，不需要被清理
                return node;
            }
            // 检查该 TrieNode 是否还有后缀
            for (int c = 0; c < R; c++) {
                if (node.children[c] != null) {
                    // 只要存在一个子节点（后缀树枝），就不需要被清理
                    return node;
                }
            }
            // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
            return null;
        }


        /**
         * 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
         * return 有可能为null
         */
        public TrieNode<V> getNode(
                TrieNode<V> node, String key) {

            TrieNode p = node;
            // 从节点 node 开始搜索 key
            for (int i = 0; i < key.length(); i++) {
                if (p == null) {
                    // 无法向下搜索
                    return null;
                }

                // 向下搜索
                p = p.children[key.charAt(i)];
            }
            return p;
        }

        public int size() {
            return size;
        }

    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
