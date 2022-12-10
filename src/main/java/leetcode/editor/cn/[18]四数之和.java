package leetcode.editor.cn;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 1446 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);

    }

    /**
     * todo 一定注意 int型 越界的问题
     * n数之和,至少2数之和,nums必须是排序好
     */
    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {

        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 2 || size < n) {
            return result;
        }

        if (n == 2) {
            int left = start, right = size - 1;
            while (left < right) {

                int leftNum = nums[left];
                int rightNum = nums[right];
                int sum = leftNum + rightNum;
                if (sum < target) {
                    while (left < right && nums[left] == leftNum) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && rightNum == nums[right]) {
                        right--;
                    }
                } else if (sum == target) {
                    result.add(new ArrayList<>(Arrays.asList(leftNum, rightNum)));
                    while (left < right && nums[left] == leftNum) {
                        left++;
                    }
                    while (left < right && rightNum == nums[right]) {
                        right--;
                    }
                }
            }
        } else {
            // n大于2 的情况
            for (int i = start; i < size; ) {
                int iNum = nums[i];
                List<List<Integer>> resList = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> res : resList) {
                    res.add(iNum);
                    result.add(res);
                }

                // 排除 重复的元素
                while (i < size && nums[i] == iNum) {
                    i++;
                }
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
