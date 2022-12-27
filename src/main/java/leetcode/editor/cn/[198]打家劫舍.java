package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution198 {

    /**
     * 动态规划
     * 一维 dp
     */
    public int rob1(int[] nums) {
        int m = nums.length;

        int[] dp = new int[m + 2];
        // base case:dp[0] = 0; dp[1]=0
        for (int i = 2; i < m + 2; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 2] + dp[i - 2]);
        }
        return dp[m + 1];
    }

    /**
     * 动态规划
     * 压缩 一维 dp
     */
    public int rob(int[] nums) {
        int m = nums.length;


        // base case:dp[0] = 0; dp[1]=0
        int pre_1 = 0;
        int pre_2 = 0;
        int cur = 0;
        for (int i = 0; i < m ; i++) {
            cur = Math.max(pre_1, nums[i] + pre_2);
            pre_2 = pre_1;
            pre_1 = cur;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
