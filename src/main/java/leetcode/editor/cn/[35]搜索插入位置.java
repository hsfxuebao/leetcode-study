package leetcode.editor.cn;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2204, 👎 0 
//
//
//
//

/**
 * 搜索插入位置
 *
 * @author hsfxuebao
 * 2023-11-17 20:35:23 
 */
class P35_SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new P35_SearchInsertPosition().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {

        // 搜索左侧边界的二分查找
        return searchInsert1(nums, target);

    }

        private int searchInsert1(int[] nums, int target) {

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (nums[mid] > target) {
                    right = mid -1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    right = mid-1;
                }
            }

            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
