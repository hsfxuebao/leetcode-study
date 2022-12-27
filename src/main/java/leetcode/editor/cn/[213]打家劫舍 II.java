package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution213 {

    public int rob(int[] nums) {

        int m = nums.length;
        if (m <= 0) {
            return 0;
        }
        if (m == 1) {
            return nums[0];
        }
        return Math.max(robFor(nums, 0, m - 1), robFor(nums, 1, m));

    }

    /**
     * 动态规划
     * 压缩 一维 dp
     */
    public int robFor(int[] nums, int left, int right) {
        // base case:dp[0] = 0; dp[1]=0
        int pre_1 = 0;
        int pre_2 = 0;
        int cur = 0;
        for (int i = left; i < right ; i++) {
            cur = Math.max(pre_1, nums[i] + pre_2);
            pre_2 = pre_1;
            pre_1 = cur;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
