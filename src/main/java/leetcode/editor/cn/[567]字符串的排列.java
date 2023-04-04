package leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 902, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符串的排列
 *
 * @author hsfxuebao
 * 2023-04-04 09:44:02 
 */
class P567_PermutationInString{
    public static void main(String[] args) {
        Solution solution = new P567_PermutationInString().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        int[] need = new int[26];
        int[] window = new int[26];
        Set<Character> needSet = new HashSet<>();
        int valid = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need[c - 'a']++;
            needSet.add(c);
        }

        int left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
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
            while (right - left >= s1.length()) {
                // 更新结果
                if (valid == needSet.size()) {
                    return true;
                }

                char c1 = s2.charAt(left);
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
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
