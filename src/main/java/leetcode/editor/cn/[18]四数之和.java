package leetcode.editor.cn;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
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
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1565, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author hsfxuebao
 * 2023-04-11 09:27:32 
 */
class P18_FourSum{
    public static void main(String[] args) {
        Solution solution = new P18_FourSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        return nNumberSum(nums, 4, 0,  target);

    }

        /**
         * n 数之和
         * 注意 nums必须是排好序的
         */
        private List<List<Integer>> nNumberSum(int[] nums, int n, int startIndex, long target) {
            List<List<Integer>> result = new ArrayList<>();

            // 两数之和 base
            if (n == 2) {

                int left = startIndex, right = nums.length -1;
                while (left < right) {
                    int leftNum = nums[left];
                    int rightNum = nums[right];
                    int sum = leftNum + rightNum;
                    if (sum > target) {
                        while (left < right && nums[right] == rightNum) {
                            right--;
                        }
                    } else if (sum < target) {
                        while (left < right && nums[left] == leftNum) {
                            left++;
                        }
                    } else {
                        List<Integer> res = new ArrayList<>();
                        res.add(leftNum);
                        res.add(rightNum);
                        result.add(res);
                        while (left < right && nums[right] == rightNum) {
                            right--;
                        }
                        while (left < right && nums[left] == leftNum) {
                            left++;
                        }
                    }
                }

            } else {
                // n数之和
                for (int i = startIndex; i < nums.length; ) {
                    int num = nums[i];
                    List<List<Integer>> lists = nNumberSum(nums, n - 1, i + 1, target - num);
                    for (List<Integer> list : lists) {
                        List<Integer> res = new ArrayList<>();
                        res.add(num);
                        res.addAll(list);
                        result.add(res);
                    }
                    // 跳过相同数
                    while (i < nums.length && nums[i] == num) {
                        i++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
