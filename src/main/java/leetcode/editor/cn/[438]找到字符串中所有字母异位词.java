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
// 👍 1281, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 *
 * @author hsfxuebao
 * 2023-09-14 20:09:46 
 */
class P438_FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();

    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // 需要的字符
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowsMap = new HashMap<>();
        // 记录数量
        int valid = 0;
        // 记录结果
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            needMap.put(ch, needMap.getOrDefault(ch, 0)+1);
        }

        // 活动窗口
        int left = 0, right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (needMap.containsKey(ch)) {
                int oldVal = windowsMap.getOrDefault(ch, 0);
                windowsMap.put(ch, oldVal+1);
                // todo 包装类型比较大小
                if (needMap.get(ch).equals(oldVal + 1)) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {

                if (valid == needMap.size()) {
                    result.add(left);
                }
                char c = s.charAt(left);
                left++;
                // 更新窗口
                if (needMap.containsKey(c)) {
                    Integer oldVal = windowsMap.get(c);
                    if (needMap.get(c).equals(oldVal)) {
                        valid--;
                    }
                    windowsMap.put(c, oldVal-1);
                }
            }

        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
