package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 6502, 👎 0 
//
//
//
//

/**
 * 最长回文子串
 *
 * @author hsfxuebao
 * 2023-05-21 18:29:19 
 */
class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 以i为中心，以i,i+1 为中心
            String palindrome = palindrome(s, i, i);
            if (palindrome.length() > result.length()) {
                result = palindrome;
            }

            String palindrome1 = palindrome(s, i, i + 1);
            if (palindrome1.length() > result.length()) {
                result = palindrome1;
            }

        }
        return result;

    }

        // 回文串
        private String palindrome(String s, int left, int right) {

            while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left+1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
