package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;


class Solution300 {

    /**
     * 最长递增子序列
     * 时间复杂度 o(n^2)
     * 空间复杂度 o(n)
     */
    public int lengthOfLIS1(int[] nums) {

        // dp数组：以当前元素结尾 最长递增子序列的长度
        int[] dp = new int[nums.length];

        // base case
        // 每个元素 至少以自身结尾
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 遍历 找到 最大的数值
        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }

        return res;
    }

    /**
     * 纸牌堆玩法
     * 时间复杂度 o(nlogn)
     * 空间复杂度 o(n)
     */
    public int lengthOfLIS(int[] nums) {

        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            // 二分查找,最左侧
            int left = 0, right = piles - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid - 1;
                } else if (poker == top[mid]) {
                    right = mid - 1;
                }
            }
            // 没有找到
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }

        return piles;
    }

//    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int res = new Solution().lengthOfLIS(nums);
//        System.out.println(res);
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
