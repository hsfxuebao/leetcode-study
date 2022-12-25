package leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1143 {
    /**
     * 动态规划
     * 二维dp
     */
    public int longestCommonSubsequence1(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        // base case dp[..][0] = 0; dp[0][..] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
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
