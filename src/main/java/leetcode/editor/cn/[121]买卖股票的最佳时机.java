package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution121 {

    /**
     * 动态规划
     * 一维dp
     */
    public int maxProfit1(int[] prices) {

        int m = prices.length;
        int[][] dp = new int[m][2];

        for (int i = 0; i < m; i++) {
            // base case
            if (i - 1 < 0) {
               dp[0][0] =  0;
               dp[0][1] = -prices[i];
               continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[m - 1][0];

    }
    /**
     * 动态规划
     * 压缩  一维dp
     */
    public int maxProfit(int[] prices) {

        int m = prices.length;
        // base case
        int pre0 = 0;
        int pre1 = -prices[0];

        for (int i = 1; i < m; i++) {

            pre0 = Math.max(pre0, pre1 + prices[i]);
            pre1 = Math.max(pre1, -prices[i]);
        }
        return pre0;
    }

    /**
     * 当前索引i后面的最大值
     */
    public int maxProfit2(int[] prices) {
        int m = prices.length;
        int[] backMax = new int[m];
        // base case
        backMax[m - 1] = prices[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            backMax[i] = Math.max(backMax[i + 1], prices[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, backMax[i] - prices[i]);
        }
        return res;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
