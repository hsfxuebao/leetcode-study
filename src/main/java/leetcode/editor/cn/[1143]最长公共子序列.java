package leetcode.editor.cn;


/**
 * 最长公共子序列
 *
 * @author hsfxuebao
 * 2023-04-17 21:32:28 
 */
class P1143_LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new P1143_LongestCommonSubsequence().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 二维dp
         * @param text1
         * @param text2
         * @return
         */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 当前字符相等
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

        /**
         * 一维dp
         */
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[] dp = new int[n+1];
            for (int i = 1; i <= m; i++) {
                int pre = 0;
                for (int j = 1; j <= n; j++) {
                    int temp = dp[j];
                    // 当前字符相等
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[j] = 1 + pre;
                    } else {
                        dp[j] = Math.max(dp[j-1], dp[j]);
                    }
                    pre = temp;
                }
            }
            return dp[n];
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
