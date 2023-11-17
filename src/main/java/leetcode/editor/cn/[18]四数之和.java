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
// 👍 1796, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author hsfxuebao
 * 2023-11-15 14:50:52 
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
        return nSum(nums, 4, 0, target);
    }

        private List<List<Integer>> nSum(int[] nums, int n, int startIndex, long target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < n) {
                return res;
            }

            if (n > 2) {
                for (int i = startIndex; i < nums.length; ) {
                    int num = nums[i];
                    List<List<Integer>> lists = nSum(nums, n - 1, i + 1, target - num);
                    for (List<Integer> list : lists) {
                        list.add(num);
                        res.add(list);
                    }
                    // 跳过重复的元素
                    while (i < nums.length && nums[i] == num) {
                        i++;
                    }
                }

            } else {
                return twoSum(nums, startIndex, target);
            }
            return res;
        }



        public List<List<Integer>> twoSum(int[] nums, int startIndex, long target) {

            List<List<Integer>> result = new ArrayList<>();
            int left = startIndex, right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                long sum = leftNum + rightNum;
                if (sum > target) {
                    while (right > startIndex && nums[right] == rightNum) {
                        right--;
                    }
                } else if (sum < target) {
                    while (left < nums.length && nums[left] == leftNum) {
                        left++;
                    }
                } else if (sum == target) {

                    // 加入到结果中
                    List<Integer> res = new ArrayList<>();
                    res.add(leftNum);
                    res.add(rightNum);
                    result.add(res);
                    // 跳过重复的元素
                    while (right > startIndex && nums[right] == rightNum) {
                        right--;
                    }
                    while (left < nums.length && nums[left] == leftNum) {
                        left++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
