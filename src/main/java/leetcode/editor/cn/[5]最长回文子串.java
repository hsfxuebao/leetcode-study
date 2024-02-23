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
// 👍 6966, 👎 0 
//
//
//
//

/**
 * 最长回文子串
 *
 * @author hsfxuebao
 * 2023-12-08 10:02:56 
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

            // 以i为中心，i和i+1为中心扩散
            String palindrome = palindrome(s, i, i);
            if (palindrome.length() > res.length()) {
                res = palindrome;
            }
            String palindrome1 = palindrome(s, i, i + 1);
            if (palindrome1.length() > res.length()) {
                res = palindrome1;
            }
        }
        return res;

    }

    public String palindrome(String s, int left, int right) {

        while (left >= 0 && left < s.length() && right >= 0 && right < s.length()
            && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);


    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
