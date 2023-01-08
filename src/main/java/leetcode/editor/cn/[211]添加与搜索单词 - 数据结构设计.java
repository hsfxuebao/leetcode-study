package leetcode.editor.cn;

//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 104 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 
// 👍 479 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 添加与搜索单词 - 数据结构设计
 *
 * @author hsfxuebao
 * 2023-01-08 17:21:59 
 */
class P211_DesignAddAndSearchWordsDataStructure{
    public static void main(String[] args) {
        WordDictionary solution = new P211_DesignAddAndSearchWordsDataStructure().new WordDictionary();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {

        TrieSet set = new TrieSet();
    public WordDictionary() {

    }
    
    public void addWord(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        return set.hasKeyWithPattern(word);
    }
}


    class TrieMap<V> {

        // ASCII 码个数
        private static final int R = 26;
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
                return root.val != null;
            }
            // 选择集
            char c = pattern.charAt(i);
            TrieNode[] children = root.children;
            // 匹配通配符
            if ('.' == c) {

                for (int j = 0; j < R; j++) {
                    if (hasKeyWithPattern(children[j], pattern, i + 1)) {
                        return true;
                    }
                }

            } else {
                return hasKeyWithPattern(children[c  - 'a'], pattern, i+1);
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
            node.children[c - 'a'] = put(node.children[c - 'a'], key, val, i + 1);
            return node;
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
                p = p.children[key.charAt(i) - 'a'];
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


        /***** 查 *****/

        // 判断元素 key 是否存在集合中
        public boolean contains(String key) {
            return map.containsKey(key);
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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
