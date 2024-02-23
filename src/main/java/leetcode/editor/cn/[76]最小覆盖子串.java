package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 2753, 👎 0 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author hsfxuebao
 * 2023-11-24 09:53:01 
 */
class P76_MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        String res = "";
        int minLen = Integer.MAX_VALUE;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {

                window.put(c, window.getOrDefault(c, 0) +1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {

                int len = right - left;
                if (len < minLen) {
                    minLen = len;
                    res = s.substring(left, right);
                }
                char ch = s.charAt(left);
                left++;
                if (need.containsKey(ch)) {
                    int oldVal = window.get(ch);
                    window.put(ch, oldVal - 1);
                    if (need.get(ch).equals(oldVal)) {
                        valid--;
                    }
                }
            }

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
