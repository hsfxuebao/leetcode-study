package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {

    /**
     * 动态规划
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        // 寻找最大
        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    /**
     * 动态规划
     * 压缩 dp
     */
    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        // base case
        // 寻找最大
        int pre = nums[0];
        int res = nums[0];
        int cur;
        for (int i = 1; i < n; i++) {
            cur = Math.max(nums[i], pre + nums[i]);
            res = Math.max(res, cur);
            pre = cur;
        }

        return res;
    }
    /**
     * 前缀和数组
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 构造 nums 的前缀和数组
        int[] preSum = new int[n + 1];

        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int minVal = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // 维护 minVal 是 preSum[0..i] 的最小值
            minVal = Math.min(minVal, preSum[i]);
            // 以 nums[i] 结尾的最大子数组和就是 preSum[i+1] - min(preSum[0..i])
            res = Math.max(res, preSum[i + 1] - minVal);
        }
        return res;
    }


    /**
     * 活动窗口
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;

        int left = 0, right = 0;
        int windowRes = 0;
        while (right < len) {

            // 右指针增加
            windowRes += nums[right];
            res = Math.max(windowRes, res);
            right++;


            // 左指针增加
            while (windowRes < 0) {
                windowRes -= nums[left];
                left++;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
