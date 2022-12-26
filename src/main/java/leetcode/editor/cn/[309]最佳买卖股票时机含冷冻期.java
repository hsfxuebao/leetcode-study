package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

class Solution309 {
    /**
     * 动态规划
     * 二维dp
     */
    public int maxProfit1(int[] prices) {
        int m = prices.length;
        int[][] dp = new int[m][2];

        for (int i = 0; i < m; i++) {
            // base case
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1],  - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);

        }
        return dp[m - 1][0];
    }
    /**
     * 动态规划
     * 压缩 二维dp
     */
    public int maxProfit(int[] prices) {
        int m = prices.length;

        int pre_i_0 = 0;
        int pre_i_1 = -prices[0];
        int pre_j_0 = 0;

        for (int i = 0; i < m; i++) {
            int temp = pre_i_0;
            pre_i_0 = Math.max(pre_i_0, pre_i_1 + prices[i]);
            pre_i_1 = Math.max(pre_i_1, pre_j_0 - prices[i]);
            pre_j_0 = temp;
        }
        return pre_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
