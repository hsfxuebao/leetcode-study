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
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
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
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 2268 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        // 维护两个map记录窗口中符合条件的字符以及need
        Map<Character, Integer> needs = new HashMap<>();
        // needs中存储的是需要的字符以及数量
        Map<Character, Integer> windows = new HashMap<>();

        // 初始化 needs的数据
        for (Character c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        // 双指针
        int left = 0, right = 0;
        // 记录当前窗口中符合needs要求的字符数量，当count==needs.size()的时候，可以左移窗口
        int count = 0;
        // start符合最优解的起始位置，length表示最终窗口的长度，并且以length做比较，选出最优解
        int start=0, length = Integer.MAX_VALUE;

        // 一次遍历找 "可行解"
        while (right < s.length()) {

            // 更新窗口
            char rightChar = s.charAt(right);
            // 窗口扩大
            right++;
            // 右移
            if (needs.containsKey(rightChar)) {
                //
                int num = windows.getOrDefault(rightChar, 0) + 1;
                windows.put(rightChar, num);
                if (num == needs.get(rightChar)) {
                    count++;
                }
            }
            // 左指针 向右移动的条件
            while (count == needs.size()) {
                // 不断“打擂”找满足条件的len最短值,并记录最短的子串的起始位序start
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                // 左节点 更新窗口
                char leftChar = s.charAt(left);
                left++;  // 窗口缩小
                if (needs.containsKey(leftChar)) {
                    Integer recordNum = windows.get(leftChar);
                    if (needs.get(leftChar).equals(recordNum)) {
                        count--;
                    }

                    windows.put(leftChar,  recordNum - 1);
                }


            }
        }

        return length == Integer.MAX_VALUE
               ? ""
               : s.substring(start, start + length);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
