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
// 👍 6929, 👎 0 
//
//
//
//

/**
 * 最长回文子串
 *
 * @author hsfxuebao
 * 2023-11-16 15:58:12 
 */
class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {

            String palindrome1 = palindrome(s, i, i);
            String palindrome2 = palindrome(s, i, i + 1);
            if (palindrome1.length() > res.length()) {
                res = palindrome1;
            }
            if (palindrome2.length() > res.length()) {
                res = palindrome2;
            }
        }
        return res;
    }

    // 返回最长回文子串
        private String palindrome(String s, int i, int j) {

            int left = i, right = j;
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
