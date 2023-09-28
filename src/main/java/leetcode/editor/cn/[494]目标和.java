package leetcode.editor.cn;

//给你一个非负整数数组 nums 和一个整数 target 。 
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
//
// Related Topics数组 | 动态规划 | 回溯 
//
// 👍 1755, 👎 0 
//
//
//
//

/**
 * 目标和
 *
 * @author hsfxuebao
 * 2023-09-28 09:08:38 
 */
class P494_TargetSum{
    public static void main(String[] args) {
        Solution solution = new P494_TargetSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 找到x的值
        if ((sum + target) % 2 == 1) {
            return 0;
        }

        int number = (sum + target) / 2;
        if (number < 0) {
            return 0;
        }

        int[][] dp = new int[nums.length+1][number+1];
        // base case
//        for (int i = 0; i <= nums.length; i++) {
//            dp[i][0] = 1;
//        }
         dp[0][0] = 1;
        // todo 统计个数的，只需要设置dp[0][0]=1 对于j=0列迭代数据生成
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= number; j++) {

                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[nums.length][number];



    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
