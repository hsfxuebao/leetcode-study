package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * 动态规划
     * 二维dp
     */
    public boolean canPartition1(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 基数
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // 重量不够
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 要 或 不要  这个物品
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * 动态规划 0-1背包问题
     * 一维dp
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int n = nums.length;
        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        // base case
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
