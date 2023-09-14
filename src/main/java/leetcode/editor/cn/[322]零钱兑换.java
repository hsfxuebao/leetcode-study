package leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics广度优先搜索 | 数组 | 动态规划 
//
// 👍 2402, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author hsfxuebao
 * 2023-04-20 21:12:27 
 */
class P322_CoinChange{
    public static void main(String[] args) {
        Solution solution = new P322_CoinChange().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 二维dp
         */
    public int coinChange(int[] coins, int amount) {

        // dp[i][j] 表示第i面值的金额，凑成金额j，需要最少硬币数
        int[][] dp = new int[coins.length+1][amount+1];
        // 全部填充 amount+1的数值，若dp[i][j] = amount+1，表示凑不成改金额
        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], amount+1);
        }
        // base case j=0时，dp[i][0] = 0
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {

                // 可以拿 coins[i]对应的金额面值
                if (j - coins[i - 1] >= 0) {
                    // min(拿，不拿)
                    // 可以重复拿
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                } else {

                    dp[i][j] = dp[i-1][j];

                }

            }
        }
        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];

    }



}
//leetcode submit region end(Prohibit modification and deletion)
 
}
