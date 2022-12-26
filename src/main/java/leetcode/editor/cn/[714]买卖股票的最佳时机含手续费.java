package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution714 {
    /**
     * 动态规划
     * 二维dp
     */
    public int maxProfit1(int[] prices, int fee) {
        int m = prices.length;
        int[][] dp = new int[m][2];

        for (int i = 0; i < m; i++) {
            // base case
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);

        }
        return dp[m - 1][0];
    }

    /**
     * 动态规划
     * 压缩 二维dp
     */
    public int maxProfit(int[] prices,int fee) {
        int m = prices.length;
        // base case

        int pre_i_0 = 0;
        int pre_i_1 = -prices[0] - fee;

        for (int i = 1; i < m; i++) {

            pre_i_0 = Math.max(pre_i_0, pre_i_1 + prices[i]);
            pre_i_1 = Math.max(pre_i_1, pre_i_0 - prices[i] - fee);
        }
        return pre_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
