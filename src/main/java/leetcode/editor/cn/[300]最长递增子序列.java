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
// 👍 3149, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author hsfxuebao
 * 2023-04-17 19:19:42 
 */
class P300_LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 纸牌堆算法
         * 最长递增子序列
         * 时间复杂度 o(n*logn)
         * 空间复杂度 o(n)
         */
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int[] temp = new int[nums.length];
            int cap = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                // 搜索左侧边界的 二分查找
                int left = 0, right = cap;
                while (left < right) {

                    int mid = left + (right - left)/2;
                    if (temp[mid] > num) {
                        right = mid;
                    } else if (temp[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (left == cap) {
                    cap++;
                }
                temp[left] = num;
            }
            return cap;

        }
        /**
         * 最长递增子序列
         * 时间复杂度 o(n^2)
         * 空间复杂度 o(n)
         */
    public int lengthOfLIS1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j]+1);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < result.length; i++) {
            res = Math.max(res, result[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
