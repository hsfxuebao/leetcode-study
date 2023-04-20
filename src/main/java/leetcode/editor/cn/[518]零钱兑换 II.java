package leetcode.editor.cn;

//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1056, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 零钱兑换 II
 *
 * @author hsfxuebao
 * 2023-04-18 20:53:25 
 */
class P518_CoinChangeIi{
    public static void main(String[] args) {
        Solution solution = new P518_CoinChangeIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 二维dp
         * @param amount
         * @param coins
         * @return
         */
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        // i 从 1 开始
        // 定义dp[i][j] 表示对于前i个零钱，总钱数为j,最大有多少种兑换方式
        int[][] dp = new int[len+1][amount+1];
        // base case
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    // 不拿 和 拿 相加
                    // 拿 由于钱 是有重复的，所以可以重复拿第i个钱数
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    // 不拿
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][amount];

    }

        /**
         * 一维dp
         */
        public int change(int amount, int[] coins) {
            int len = coins.length;
            // i 从 1 开始
            // 定义dp[i][j] 表示对于前i个零钱，总钱数为j,最大有多少种兑换方式
            int[] dp = new int[amount+1];
            // base case
            dp[0] = 1;

            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] >= 0) {
                        // 不拿 和 拿 相加
                        // 拿 由于钱 是有重复的，所以可以重复拿第i个钱数
                        dp[j] = dp[j] + dp[j-coins[i-1]];
                    }
                }
            }
            return dp[amount];

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
