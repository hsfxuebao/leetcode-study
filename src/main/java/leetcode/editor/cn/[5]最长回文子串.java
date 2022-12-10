package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。
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
// Related Topics 字符串 动态规划 
// 👍 5962 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public String longestPalindrome(String s) {

        String resultStr = "";

        for (int i = 0; i < s.length(); i++) {
            // 以i 为中心的 回文串
            String leftStr = palindrome(s, i, i);
            resultStr = resultStr.length() > leftStr.length()
                    ? resultStr : leftStr;
            // 以i i+1为中心的回文串
            String rightStr = palindrome(s, i, i + 1);
            resultStr = resultStr.length() > rightStr.length()
                        ? resultStr : rightStr;

        }
        return resultStr;

    }

    public String palindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
