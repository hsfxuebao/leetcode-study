package leetcode.editor.cn;

//给定两个单词 word1 和
// word2 ，返回使得
// word1 和 
// word2 相同所需的最小步数。 
//
// 每步 可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例 1： 
//
// 
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
// 
//
// 示例 2: 
//
// 
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 和 word2 只包含小写英文字母 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 568, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 两个字符串的删除操作
 *
 * @author hsfxuebao
 * 2023-04-18 19:29:16 
 */
class P583_DeleteOperationForTwoStrings{
    public static void main(String[] args) {
        Solution solution = new P583_DeleteOperationForTwoStrings().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 最长公共子序列问题
         */
    public int minDistance(String word1, String word2) {
        int commonLen = longestCommonSubsequence(word1, word2);
        return word1.length() - commonLen + word2.length() - commonLen;
    }

        public int longestCommonSubsequence(String text1, String text2) {

            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {

                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[m][n];

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
