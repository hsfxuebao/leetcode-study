package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution188 {

    public int maxProfit(int maxK, int[] prices) {
        int m = prices.length;
        // 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2
        if (maxK > m / 2) {
            // 复用之前交易次数 k 没有限制的情况
            return maxProfit_k_inf(prices);
        }

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

    /**
     * 动态规划
     * 压缩 二维dp
     */
    public int maxProfit_k_inf(int[] prices) {
        int m = prices.length;
        // base case

        int pre_i_0 = 0;
        int pre_i_1 = -prices[0];

        for (int i = 1; i < m; i++) {

            pre_i_0 = Math.max(pre_i_0, pre_i_1 + prices[i]);
            pre_i_1 = Math.max(pre_i_1, pre_i_0 - prices[i]);
        }
        return pre_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
