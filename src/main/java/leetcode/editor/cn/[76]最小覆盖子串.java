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
// 👍 2429, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 2023-04-04 21:41:13 
 */
class P76_MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        // need的子串
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowsMap = new HashMap<>();
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int oldVal = needMap.getOrDefault(ch, 0);
            needMap.put(ch, oldVal+1);
        }
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {

            char ch = s.charAt(right);
            right++;
            if (needMap.containsKey(ch)) {
                Integer oldVal = windowsMap.getOrDefault(ch, 0);
                windowsMap.put(ch, oldVal+1);
                if (needMap.get(ch).equals(oldVal + 1)) {
                    valid++;
                }
            }

             while (valid == needMap.size()) {
                // 更新长度
                 if (right - left < len) {
                     start = left;
                     len = right - left;
                 }
                 char chs = s.charAt(left);
                 if (needMap.containsKey(chs)) {
                     int oldVal = windowsMap.get(chs);
                     if (needMap.get(chs).equals(oldVal)) {
                         valid--;
                     }
                     windowsMap.put(chs, oldVal-1);
                 }
                 left++;
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);



    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
