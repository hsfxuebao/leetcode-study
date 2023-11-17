package leetcode.editor.cn;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics数组 | 二分查找 | 动态规划 
//
// 👍 3469, 👎 0 
//
//
//
//

/**
 * 最长递增子序列
 *
 * @author hsfxuebao
 * 2023-11-17 20:10:31 
 */
class P300_LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {


        // 二分查找
        return lengthOfLIS1(nums);
    }

        // 二分查找
        private int lengthOfLIS1(int[] nums) {
            int[] top = new int[nums.length];
            // 初始化长度为1
            top[0] = nums[0];
            int index = 1;
            // 对于数组中的每一个值
            for (int i = 1; i < nums.length; i++) {
                int target = nums[i];
                int left = 0, right = index -1;
                // 最左侧
                while (left <= right) {
                    int mid = left + (right - left) /2;
                    if (top[mid] > target) {
                        right = mid -1;
                    } else if (top[mid] < target) {
                        left = mid + 1;
                    } else if (top[mid] == target) {
                        right = mid - 1;
                    }
                }
                // 越界
                if (left == index) {
                    index++;
                }
                top[left] = target;
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
