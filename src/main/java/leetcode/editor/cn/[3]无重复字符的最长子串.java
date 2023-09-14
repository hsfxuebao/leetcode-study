package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 9623, 👎 0 
//
//
//
//

/**
 * 无重复字符的最长子串
 *
 * @author hsfxuebao
 * 2023-09-14 19:46:13 
 */
class P3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        int[] windows = new int[256];
        int res = 0;
        // 滑动窗口
        int left = 0, right = 0;
        while (right < sLen) {
            // 右指针 向右移动
            char ch = s.charAt(right);
            right++;
            // 窗口内的更新操作
            windows[ch]++;

            // 左指针 向右移动
            while (windows[ch] > 1) {
                char chs = s.charAt(left);
                windows[chs]--;
                left++;
            }
            // 更新
            res = Math.max(res, right - left);

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
