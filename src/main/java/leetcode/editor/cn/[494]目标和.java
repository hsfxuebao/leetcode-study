package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 1469 👎 0

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

/**
 * 目标和
 *
 * @author hsfxuebao
 * 2023-01-02 14:37:43 
 */
class P494_TargetSum{
    public static void main(String[] args) {
        Solution solution = new P494_TargetSum().new Solution();
        int[] nums = {1,1,1,1,1};
        solution.findTargetSumWays(nums, 3);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 回溯算法
         */
        private int result = 0;
        public int findTargetSumWays1(int[] nums, int target) {
            if (nums.length <= 0) {
                return 0;
            }
            backtrack1(nums, 0, target);
            return result;
        }
        private void backtrack1(int[] nums, int i, int remind) {
            if (i == nums.length) {
                if (remind == 0) {
                    result++;
                }
                return;
            }
            // 做选择
            // 选择 加号
            backtrack1(nums, i+1, remind - nums[i]);

            // 选择减号
            backtrack1(nums, i+1, remind + nums[i]);
        }

        /**
         * 回溯算法 + 备忘录
         */
        // key:位置i 对应某个值 有多少种结果集
        private Map<String, Integer> memo = new HashMap<>();
        public int findTargetSumWays2(int[] nums, int target) {
            if (nums.length <= 0) {
                return 0;
            }
            return backtrack2(nums, 0, target);

        }

        private int backtrack2(int[] nums, int i, int remind) {
            if (i == nums.length) {
                if (remind == 0) {
                    return 1;
                }
                return 0;
            }

            // 判断是否 在memo中
            String key = i + "," + remind;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            // 做选择
            int res = backtrack2(nums, i+1, remind-nums[i])
                    + backtrack2(nums, i+1, remind+nums[i]);
            memo.put(key, res);
            return res;
        }

        /**
         * 动态规划
         * 二维dp
         * 如果我们把 nums 划分成两个子集 A 和 B，
         * 分别代表分配 + 的数和分配 - 的数，那么他们和 target 存在如下关系：
         *
         * sum(A) - sum(B) = target
         * sum(A) = target + sum(B)
         * sum(A) + sum(A) = target + sum(B) + sum(A)
         * 2 * sum(A) = target + sum(nums)
         * sum(A) = (target + sum(nums)) / 2，
         * 也就是把原问题转化成：nums 中存在几个子集 A，使得 A 中元素的和为 (target + sum(nums)) / 2？
         */
        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length <= 0) {
                return 0;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < target || (target + sum) % 2 == 1) {
                return 0;
            }
            int remind = (target + sum) / 2;
            if (remind < 0) {
                return 0;
            }

            int[][] dp = new int[nums.length+1][remind+1];
            // 初始化
            dp[0][0] = 1;


            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j <= remind; j++) {
                    if (j >= nums[i-1]) {
                        // 两种选择的结果之和
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    } else {
                        // 背包的空间不足，只能选择不装物品 i
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[nums.length][remind];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
