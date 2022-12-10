package leetcode.editor.cn;
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
// ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
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
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 5459 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int numLen = nums.length;
        if (numLen < 3) {
           return result;
        }

        Arrays.sort(nums);

        // 固定一个数，求 两个之和的所有可能结果
        for (int i = 0; i < nums.length;) {
            int num = nums[i];
            // 计算从i+1位置开始，和为0-num
            List<List<Integer>> twoSumList = twoSumAll(nums, i + 1, -num);
            for (List<Integer> res : twoSumList) {
                res.add(num);
                result.add(res);
            }
            // 第一个数重复的情况
            while (i < nums.length && nums[i] == num) {
                i++;
            }

        }
        return result;

    }

    public static List<List<Integer>> twoSumAll(int[] nums, int index, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int left = index, right = nums.length - 1;
        while (left < right) {

            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum < target) {
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            } else if (sum == target) {
                List<Integer> res = new ArrayList<>();
                res.add(leftNum);
                res.add(rightNum);
                result.add(res);
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
