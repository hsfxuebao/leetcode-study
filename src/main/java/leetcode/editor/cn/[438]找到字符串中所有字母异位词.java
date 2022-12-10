package leetcode.editor.cn;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 1050 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        // 初始化
        for (Character c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {

            char rightChar = s.charAt(right);
            right++;

            if (needs.containsKey(rightChar)) {
               int num = windows.getOrDefault(rightChar, 0) + 1;
                if (num == needs.get(rightChar)) {
                    count++;
                }
                windows.put(rightChar, num);
            }

            while (right - left >= p.length()) {

                if (count == needs.size()) {
                    res.add(left);
                }

                char leftChar = s.charAt(left);
                left++;

                if (needs.containsKey(leftChar)) {
                    int num = windows.get(leftChar);
                    if (needs.get(leftChar) == num) {
                        count--;
                    }
                    windows.put(leftChar, num - 1);

                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
