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
    public int coinChange1(int[] coins, int amount) {

        int m = coins.length;
        // 定义 dp[i][j] 第i个零钱，凑成金额j,最少的数量
        int[][] dp = new int[m+1][amount+1];
        // 因为求最小值，所以默认里面都是最大值
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], amount+1);
        }
        // base case j=0时 数量为1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {

                    // 拿 与 不拿 取最小值
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);

                } else {
                    // 不拿
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[m][amount] == amount+1 ? -1 : dp[m][amount];

    }


        /**
         * 一维dp
         */
        public int coinChange(int[] coins, int amount) {

            int m = coins.length;
            // 定义 dp[i][j] 第i个零钱，凑成金额j,最少的数量
            int[] dp = new int[amount+1];
            // 因为求最小值，所以默认里面都是最大值
            Arrays.fill(dp, amount+1);
            // base case
            dp[0] = 0;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] >= 0) {
                        // 拿 与 不拿 取最小值
                        dp[j] = Math.min(dp[j], dp[j-coins[i-1]] + 1);

                    }

                }
            }
            return dp[amount] == amount+1 ? -1 : dp[amount];

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
