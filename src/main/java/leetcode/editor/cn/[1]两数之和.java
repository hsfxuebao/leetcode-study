package leetcode.editor.cn;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics数组 | 哈希表 
//
// 👍 17951, 👎 0 
//
//
//
//

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author hsfxuebao
 * 2023-11-15 10:00:40 
 */
class P1_TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1_TwoSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 双指针
         * 需要记录原始数据 的索引
         */
        public int[] twoSum1(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else if (sum == target) {
                    // 返回排序前的索引
                    return new int[]{left, right};
                }
            }
            return null;
        }

        /**
         * 时间复杂度o(n) 空间复杂度o(n)
         */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num2IndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (num2IndexMap.containsKey(target - nums[i])) {
                Integer index = num2IndexMap.get(target - nums[i]);
                return new int[]{index, i};
            } else {
                num2IndexMap.put(nums[i], i);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
