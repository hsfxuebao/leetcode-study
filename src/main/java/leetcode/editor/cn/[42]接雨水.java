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
// 👍 4853, 👎 0 
//
//
//
//

/**
 * 接雨水
 *
 * @author hsfxuebao
 * 2023-11-16 15:46:12 
 */
class P42_TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42_TrappingRainWater().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {




    public int trap(int[] height) {

        if (height == null || height.length <= 1) {
            return 0;
        }

        // 时间复杂度o(n)
//        return trap1(height);

        // 时间复杂度o(logn)
        return trap2(height);
    }

        private int trap2(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int sum = 0;
            while (left <= right) {
                int leftNum = height[left];
                int rightNum = height[right];
                leftMax = Math.max(leftNum, leftMax);
                rightMax = Math.max(rightNum, rightMax);

                if (leftMax >= rightMax) {
                    sum += rightMax - height[right];
                    right--;
                } else {
                    sum += leftMax - height[left];
                    left++;
                }
            }
            return sum;
        }

        private int trap1(int[] height) {

            // 当前位置左边最高，右边最高，取最小值
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            int len = height.length;
            int leftRes = 0;
            for (int i = 0; i < len; i++) {
                leftRes = Math.max(leftRes, height[i]);
                leftMax[i] = leftRes;
            }

            int rightRes = 0;
            for (int i = len - 1; i >= 0; i--) {
               rightRes = Math.max(rightRes, height[i]);
               rightMax[i] = rightRes;
            }

            int res = 0;
            for (int i = 0; i < len; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
