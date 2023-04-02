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
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2239, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author hsfxuebao
 * 2023-04-01 10:57:33 
 */
class P34_FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int leftIndex = leftBound(nums, target);
        int rightIndex = rightBound(nums, target);
        return new int[]{leftIndex, rightIndex};

    }

    public int leftBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid+1;

            } else if (nums[mid] == target) {
                right = mid;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
        public int rightBound(int[] nums, int target) {

            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left)/2;
                if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid+1;

                } else if (nums[mid] == target) {
                    left = mid + 1;
                }
            }
            if (left-1 < 0 || nums[left-1] != target) {
                return -1;
            }
            return left -1;
        }


}
//leetcode submit region end(Prohibit modification and deletion)
 
}
