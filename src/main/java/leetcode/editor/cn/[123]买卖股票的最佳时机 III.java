package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution123 {

    /**
     * 动态规划
     * 三维数组
     */
    public int maxProfit1(int[] prices) {
        int maxK = 2;
        int m = prices.length;
        int[][][] dp = new int[m][maxK + 1][2];

        for (int i = 0; i < m; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }

        }
        return dp[m - 1][maxK][0];
    }

    // 状态转移方程：
    // dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
    // dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
    // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    // dp[i][1][1] = max(dp[i-1][1][1], -prices[i])

    /**
     * 动态规划
     * 压缩 三维数组
     */
    public int maxProfit(int[] prices) {
        int maxK = 2;
        int m = prices.length;
        // base case
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);

        }
        return dp_i20;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
