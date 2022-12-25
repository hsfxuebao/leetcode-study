package leetcode.editor.cn;

import javax.crypto.Cipher;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution518 {
    /**
     * 零钱兑换二
     * 二维数组
     */
    public int change1(int amount, int[] coins) {

        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        // base case:
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {

                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[m][amount];
    }

    /**
     * 零钱兑换2
     * 以为数组
     */
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[] dp = new int[amount + 1];
        // base case:
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
