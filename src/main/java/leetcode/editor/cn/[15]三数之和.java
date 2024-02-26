package leetcode.editor.cn;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 5844, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 *
 * @author hsfxuebao
 * 2023-04-10 21:29:47 
 */
class P15_ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15_ThreeSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ) {

            int num = nums[i];

            List<List<Integer>> lists = twoSum(nums, i + 1, -num);
            for (List<Integer> list : lists) {
                list.add(num);
                res.add(list);
            }
            // 跳过重复数据
            while (i < nums.length && num == nums[i]) {
                i++;
            }
        }
        return res;

    }


        /**
         * 两数之和 不重复
         */
        public List<List<Integer>> twoSum(int[] nums, int startIndex, int target) {

            List<List<Integer>> res = new ArrayList<>();
            int left = startIndex, right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int sum = leftNum + rightNum;
                if (sum > target) {
                    while (left < right && rightNum == nums[right]) {
                        right--;
                    }
                } else if (sum < target) {
                    while (left < right && leftNum == nums[left]) {
                        left++;
                    }
                } else if (sum == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(leftNum);
                    result.add(rightNum);
                    res.add(result);
                    while (rightNum == nums[right] && left < right) {
                        right--;
                    }
                    while (leftNum == nums[left] && left < right) {
                        left++;
                    }
                }
            }
            return res;

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
