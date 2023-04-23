package leetcode.editor.cn;

//给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。 
//
// 请你返回让 s 成为回文串的 最少操作次数 。 
//
// 「回文串」是正读和反读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "zzazz"
//输出：0
//解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
// 
//
// 示例 2： 
//
// 
//输入：s = "mbadm"
//输出：2
//解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "leetcode"
//输出：5
//解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 中所有字符都是小写字母。 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 182, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 让字符串成为回文串的最少插入次数
 *
 * @author hsfxuebao
 * 2023-04-23 19:39:39 
 */
class P1312_MinimumInsertionStepsToMakeAStringPalindrome{
    public static void main(String[] args) {
        Solution solution = new P1312_MinimumInsertionStepsToMakeAStringPalindrome().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 最长回文子串
         */
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }


        public int longestPalindromeSubseq(String s) {

            // dp[i][j] 对于数组nums[i,j] 最长回文子串的长度
            int len = s.length();
            int[][] dp = new int[len][len];

            // base case i==j 值为1
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
            }

            for (int i = len - 2; i >= 0; i--) {
                for (int j = i+1; j < len; j++) {
                    // 左边 和右边  相等
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[0][len-1];

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
