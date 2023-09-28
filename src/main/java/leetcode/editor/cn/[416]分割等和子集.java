package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1890, 👎 0 
//
//
//
//

/**
 * 分割等和子集
 *
 * @author hsfxuebao
 * 2023-09-28 08:59:24 
 */
class P416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }
        // 求和 看能否整除
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;


        boolean[][] dp = new boolean[nums.length+1][target+1];
        // base case
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
