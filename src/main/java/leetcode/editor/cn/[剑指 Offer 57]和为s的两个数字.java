package leetcode.editor.cn;

//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
//
// Related Topics数组 | 双指针 | 二分查找 
//
// 👍 250, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 和为s的两个数字
 *
 * @author hsfxuebao
 * 2023-04-05 15:54:51 
 */
class P_Offer_57_HeWeiSdeLiangGeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P_Offer_57_HeWeiSdeLiangGeShuZiLcof().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }

        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
