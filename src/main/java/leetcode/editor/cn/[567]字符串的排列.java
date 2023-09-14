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
// 👍 956, 👎 0 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串的排列
 *
 * @author hsfxuebao
 * 2023-09-14 20:39:47 
 */
class P567_PermutationInString{
    public static void main(String[] args) {
        Solution solution = new P567_PermutationInString().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // need的子串
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowsMap = new HashMap<>();
        int valid = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int oldVal = needMap.getOrDefault(ch, 0);
            needMap.put(ch, oldVal+1);
        }

        int left = 0, right = 0;
        while (right < s2.length()) {

            char ch = s2.charAt(right);
            right++;
            if (needMap.containsKey(ch)) {
                int oldVal = windowsMap.getOrDefault(ch, 0);
                windowsMap.put(ch, oldVal+1);
                if (needMap.get(ch).equals(oldVal + 1)) {
                    valid++;
                }
            }


            while (right - left == s1.length()) {
                if (valid == needMap.size()) {
                    return true;
                }
                char chs = s2.charAt(left);
                left++;
                if (needMap.containsKey(chs)) {
                    int oldVal = windowsMap.get(chs);
                    if (needMap.get(chs).equals(oldVal)) {
                        valid--;
                    }
                    windowsMap.put(chs, oldVal-1);
                }

            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
