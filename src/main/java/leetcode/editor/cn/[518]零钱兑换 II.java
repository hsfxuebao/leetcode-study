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
// 👍 1193, 👎 0 
//
//
//
//

/**
 * 零钱兑换 II
 *
 * @author hsfxuebao
 * 2023-11-26 16:49:39 
 */
class P518_CoinChangeIi{
    public static void main(String[] args) {
        Solution solution = new P518_CoinChangeIi().new Solution();
        int[] coins = new int[]{1,2,5};
        System.out.println(solution.change(5, coins));
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int res = 0;
    public int change(int amount, int[] coins) {

        // 回溯算法 超时
        backtrack(coins,0, amount);
        return res;
        // 动态规划
//        return dp(coins, amount);


    }



        private void backtrack(int[] coins, int start, int target) {
            if (target == 0) {
                res++;
                return;
            }
            if (target < 0) {
                return;
            }
            // 选择集
            for (int i = start; i < coins.length; i++) {
                // 选择
                backtrack(coins, i,target - coins[i]);

            }
        }

        private int dp(int[] coins, int amount) {
            int[][] dp = new int[coins.length+1][amount+1];
            dp[0][0] = 1;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {

                    if (j - coins[i - 1] >= 0) {

                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }

                }
            }
            return dp[coins.length][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
