package leetcode.editor.cn;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 2047 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    /**
     * 二分查找，最左边元素
     */
    private int searchLeft(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        // 越界情况
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;

    }

    /**
     * 二分查找，最右边元素
     */
    private int searchRight(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (left - 1 < 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
