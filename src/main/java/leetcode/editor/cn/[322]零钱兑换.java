package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution322 {

    private int[] dp;
    public int coinChange(int[] coins, int amount) {

        dp = new int[amount + 1];
        // 初始化全部赋值为 amount+1;
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            // 对于每一种金额
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
