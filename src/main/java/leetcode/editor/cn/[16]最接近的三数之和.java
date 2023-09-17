package leetcode.editor.cn;

//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1515, 👎 0 
//
//
//
//

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author hsfxuebao
 * 2023-09-16 08:47:20 
 */
class P16_ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16_ThreeSumClosest().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ) {
            int num = nums[i];
            int twoSumClosest = twoSumClosest(nums, i + 1, target - num);
            int sum = num + twoSumClosest;
            if (Math.abs(delta) > Math.abs(target - sum)) {
                delta = target - sum;
            }
            while (i < nums.length && nums[i] == num) {
                i++;
            }
        }
        return target - delta;
    }

    // 最接近的两数之和
    public int twoSumClosest(int[] nums, int startIndex, int target) {

        int left = startIndex, right = nums.length - 1;
        int delta = Integer.MAX_VALUE;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;

            // 对比 绝对值
            if (Math.abs(delta) > Math.abs(sum - target)) {
                delta = target - sum;
            }

            if (sum > target) {
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
            } else if (sum == target){
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
            }
        }
        return target - delta; // = sum
    }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
