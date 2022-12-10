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
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 809 👎 0


import java.awt.event.WindowStateListener;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution567 {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        // 初始化needs
        for (Character c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // 判断是否满足条件
        int count = 0;

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            right++;

            if (needs.containsKey(rightChar)) {
                int num = windows.getOrDefault(rightChar, 0) + 1;
                windows.put(rightChar, num);
                if (num == needs.get(rightChar)) {
                    count++;
                }
            }

            // left指针 右移动
            while (right - left >= s1.length()) {

                // 判断是否满足条件
                if (count == needs.size()) {
                    return true;
                }

                char leftChar = s2.charAt(left);
                left++;
                if (needs.containsKey(leftChar)) {
                    int num = windows.get(leftChar);
                    if (num == needs.get(leftChar)) {
                        count--;
                    }
                    windows.put(leftChar, num - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
