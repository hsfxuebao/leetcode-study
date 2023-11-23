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
// 👍 1671, 👎 0 
//
//
//
//

/**
 * 买卖股票的最佳时机含冷冻期
 *
 * @author hsfxuebao
 * 2023-11-23 21:24:26 
 */
class P309_BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // dp[i][j] 表示第i天 是否持有股票 1-持有股票 0-没有持有股票
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {

            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                
            } else if (i -2 < 0) {

                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] +prices[i]);

                dp[i][1] = Math.max(dp[i-1][1],  - prices[i]);
            } else {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] +prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1-1][0] - prices[i]);
            }
        }
        return dp[prices.length-1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
