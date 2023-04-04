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
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1136, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 找到字符串中所有字母异位词
 *
 * @author hsfxuebao
 * 2023-04-03 21:19:32 
 */
class P438_FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 使用一维数组
         */
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int[] need = new int[26];
            int[] window = new int[26];
            Set<Character> needSet = new HashSet<>();
            int valid = 0;
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                need[c - 'a']++;
                needSet.add(c);
            }

            int left = 0, right = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                // 右移
                right++;
                // 更新窗口内数据
                if (needSet.contains(c)) {
                    window[c - 'a']++;
                    if (window[c - 'a'] == need[c - 'a']) {
                        valid++;
                    }
                }

                // 缩小窗口
                while (right - left >= p.length()) {
                    // 更新结果
                    if (valid == needSet.size()) {
                        result.add(left);
                    }

                    char c1 = s.charAt(left);
                    // 左移
                    left++;
                    // 更新窗口内数据
                    if (needSet.contains(c1)) {
                        if (window[c1 - 'a'] == need[c1 - 'a']) {
                            valid--;
                        }
                        window[c1 - 'a']--;
                    }
                }
            }
            return result;
        }

        /**
         * 使用map
         */
    public List<Integer> findAnagrams1(String s, String p) {

        List<Integer> result = new ArrayList<>();

        // 只有小写字母
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowsMap = new HashMap<>();
        // windows中的每个字母 和need 中字母数量一样 +1
        int valid = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            Integer oldVal = needMap.getOrDefault(c, 0);
            needMap.put(c, oldVal + 1);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 右移
            right++;
            // 更新数据
            if (needMap.containsKey(c)) {
                Integer windowOldVal = windowsMap.getOrDefault(c, 0);
                windowsMap.put(c, windowOldVal + 1);
                Integer needOldVal = needMap.getOrDefault(c, 0);
                if (needOldVal.equals(windowOldVal + 1)) {
                    valid++;
                }
            }


            // 左移
            while (right - left >= p.length()) {
                // 满足条件
                if (valid == needMap.size()) {
                    result.add(left);
                }
                char c1 = s.charAt(left);
                // 左移
                left++;
                // 更新窗口数据
                Integer oldVal = windowsMap.get(c1);
                if (needMap.containsKey(c1)) {
                    if (oldVal.equals(needMap.get(c1))) {
                        valid--;
                    }
                    windowsMap.put(c1, oldVal -1);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
