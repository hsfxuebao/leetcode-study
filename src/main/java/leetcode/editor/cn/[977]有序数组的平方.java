package leetcode.editor.cn;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 785, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 有序数组的平方
 *
 * @author hsfxuebao
 * 2023-04-13 09:41:08 
 */
class P977_SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new P977_SquaresOfASortedArray().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {

        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int resultIndex = nums.length - 1;

        while (left <= right) {

            int leftSqu = Math.abs(nums[left]) * Math.abs(nums[left]);
            int rightSqu = Math.abs(nums[right]) * Math.abs(nums[right]);
            if (leftSqu > rightSqu) {
                result[resultIndex--] = leftSqu;
                left++;
            } else {
                result[resultIndex--] = rightSqu;
                right--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
