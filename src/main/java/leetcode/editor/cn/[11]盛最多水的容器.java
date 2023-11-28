package leetcode.editor.cn;

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics贪心 | 数组 | 双指针 
//
// 👍 4703, 👎 0 
//
//
//
//

/**
 * 盛最多水的容器
 *
 * @author hsfxuebao
 * 2023-11-25 21:31:39 
 */
class P11_ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new P11_ContainerWithMostWater().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length -1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, area);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
