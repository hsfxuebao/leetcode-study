package leetcode.editor.cn;

//在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词
//根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继
//承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 你需要输出替换之后的句子。 
//
// 
//
// 示例 1： 
//
// 
//输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the
// battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 2： 
//
// 
//输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写字母组成。 
// 1 <= sentence.length <= 10^6 
// sentence 仅由小写字母和空格组成。 
// sentence 中单词的总量在范围 [1, 1000] 内。 
// sentence 中每个单词的长度在范围 [1, 1000] 内。 
// sentence 中单词之间由一个空格隔开。 
// sentence 没有前导或尾随空格。 
// 
//
// 
// Related Topics 字典树 数组 哈希表 字符串 
// 👍 267 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 单词替换
 *
 * @author hsfxuebao
 * 2023-01-08 17:10:15
 */
class P648_ReplaceWords{
    public static void main(String[] args) {
        Solution solution = new P648_ReplaceWords().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        TrieSet set = new TrieSet();
    public String replaceWords(List<String> dictionary, String sentence) {

        for (String dict : dictionary) {
            set.add(dict);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String shortestPre = set.shortestPrefixOf(words[i]);
            if (!shortestPre.isEmpty()) {
                sb.append(shortestPre);
            } else {
                sb.append(words[i]);
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
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
                return;
            }
            if (root.val != null) {
                res.add(path.toString());
            }

            // 选择集
            TrieNode<V>[] children = root.children;
            for (int i = 0; i < children.length; i++) {
                // 做选择
                path.append(i);
                traverse(children[i], path, res);
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
            char c = pattern.charAt(i);
            TrieNode[] children = root.children;
            // 匹配通配符
            if (".".equals(c)) {

                for (int j = 0; j < children.length; j++) {
                    // 做选择
                    path.append(j);
                    traverse(children[j], path, pattern, i+1, res);
                    // 撤销选择
                    path.deleteCharAt(path.length()-1);
                }

            } else {
                // 做选择
                path.append(c);
                traverse(children[c], path, pattern, i+1, res);
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
            if (".".equals(c)) {

                for (int j = 0; j < children.length; j++) {
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
        private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
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
        private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
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
        public TrieNode<V> getNode(TrieNode<V> node, String key) {

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

    class TrieSet {
        // 底层用一个 TrieMap，键就是 TrieSet，值仅仅起到占位的作用
        // 值的类型可以随便设置，我参考 Java 标准库设置成 Object
        private final TrieMap<Object> map = new TrieMap<>();

        /***** 增 *****/

        // 在集合中添加元素 key
        public void add(String key) {
            map.put(key, new Object());
        }

        /***** 删 *****/

        // 从集合中删除元素 key
        public void remove(String key) {
            map.remove(key);
        }

        /***** 查 *****/

        // 判断元素 key 是否存在集合中
        public boolean contains(String key) {
            return map.containsKey(key);
        }

        // 在集合中寻找 query 的最短前缀
        public String shortestPrefixOf(String query) {
            return map.shortestPrefixOf(query);
        }

        // 在集合中寻找 query 的最长前缀
        public String longestPrefixOf(String query) {
            return map.longestPrefixOf(query);
        }

        // 在集合中搜索前缀为 prefix 的所有元素
        public List<String> keysWithPrefix(String prefix) {
            return map.keysWithPrefix(prefix);
        }

        // 判断集合中是否存在前缀为 prefix 的元素
        public boolean hasKeyWithPrefix(String prefix) {
            return map.hasKeyWithPrefix(prefix);
        }

        // 通配符 . 匹配任意字符，返回集合中匹配 pattern 的所有元素
        public List<String> keysWithPattern(String pattern) {
            return map.keysWithPattern(pattern);
        }

        // 通配符 . 匹配任意字符，判断集合中是否存在匹配 pattern 的元素
        public boolean hasKeyWithPattern(String pattern) {
            return map.hasKeyWithPattern(pattern);
        }

        // 返回集合中元素的个数
        public int size() {
            return map.size();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
 
}
