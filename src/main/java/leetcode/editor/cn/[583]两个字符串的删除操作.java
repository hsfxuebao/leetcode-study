package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution583 {

    /**
     * 最长公共子序列问题
     */
    public int minDistance(String word1, String word2) {
        int comSubLen = longestCommonSubsequence(word1, word2);
        return word1.length() - comSubLen + word2.length() - comSubLen;
    }

    /**
     * 动态规划
     * 一维dp
     */
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];
        // base case dp[..][0] = 0; dp[0][..] = 0

        for (int i = 1; i <= m; i++) {
            // 记录dp[i - 1][j - 1] 的变量
            int pre = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = 1 + pre;
                } else{
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
