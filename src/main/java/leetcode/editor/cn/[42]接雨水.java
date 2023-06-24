package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 4263, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 接雨水
 *
 * @author hsfxuebao
 * 2023-04-13 20:09:55 
 */
class P42_TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42_TrappingRainWater().new Solution();
        int[] height = new int[]{4,2,0,3,2,5};
        solution.trap(height);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 时间复杂度 o(logn)
         * @param height
         * @return
         */
        public int trap(int[] height) {

            int n = height.length;
            int left = 0, right = n - 1;
            int leftMax = 0, rightMax = 0;
            int res = 0;
            while (left <= right) {

                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);

                if (leftMax > rightMax) {

                    res += rightMax - height[right];
                    right--;

                } else {
                    res += leftMax - height[left];
                    left++;
                }
            }
            return res;

        }

        /**
         * 时间复杂度0(n)
         * @param height
         * @return
         */
    public int trap3(int[] height) {
        int n = height.length;

        // 表示0-i之间的最大值
        int[] leftMax = new int[n];
        // 表示i-n 之间的最大值
        int[] rightMax = new int[n];

        int left = 0;
        for (int i = 0; i < n; i++) {
            left = Math.max(left, height[i]);
            leftMax[i] = left;
        }

        int right = 0;
        for (int i = n-1; i >= 0; i--) {
            right = Math.max(right, height[i]);
            rightMax[i] = right;
        }

        // 计算最大
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
