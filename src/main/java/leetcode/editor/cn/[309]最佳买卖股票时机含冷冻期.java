package leetcode.editor.cn;

//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1502, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 最佳买卖股票时机含冷冻期
 *
 * @author hsfxuebao
 * 2023-05-15 21:20:13 
 */
class P309_BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 二维dp
         * @param prices
         * @return
         */
    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

        /**
         * 一维dp
         */
        public int maxProfit(int[] prices) {

            if (prices.length < 2) {
                return 0;
            }
            int dp_i2_0 = 0;
            int dp_i2_1 = -prices[0];
            int dp_i_0 = Math.max(dp_i2_0, dp_i2_1 + prices[1]);
            int dp_i_1 = Math.max(dp_i2_1, -prices[1]);

            for (int i = 2; i < prices.length; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, dp_i2_0 - prices[i]);
                dp_i2_0 = temp;
            }
            return dp_i_0;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
