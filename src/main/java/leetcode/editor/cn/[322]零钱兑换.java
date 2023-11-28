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
// 👍 2633, 👎 0 
//
//
//
//

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author hsfxuebao
 * 2023-11-26 16:40:49 
 */
class P322_CoinChange{
    public static void main(String[] args) {
        Solution solution = new P322_CoinChange().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length+1][amount+1];
        // 初始化值
        for (int[] ints : dp) {
            // 对于每一行赋值 amount+1
            Arrays.fill(ints, amount+1);
        }
        // 对于第一列 赋值为0
        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (j - coins[i-1] >= 0) {

                    // 不拿  拿  取最小值
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                } else {
                    // 不拿
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount] == amount+1 ? -1 :dp[coins.length][amount];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
