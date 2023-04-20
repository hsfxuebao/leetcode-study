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
// 👍 1722, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 分割等和子集
 *
 * @author hsfxuebao
 * 2023-04-18 20:36:49 
 */
class P416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 0-1背包问题，二维dp
         */
    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        // 奇数 返回false
        if (sum % 2 != 0) {
            return false;
        }

        // 定义dp[i][j] 表示对于前i个数据，能否凑成和未j  i从1开始
        boolean[][] dp = new boolean[len+1][sum/2+1];
        // base case j=0时 都为true
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if (j - nums[i-1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 拿与不拿
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[len][sum/2];
    }

        /**
         * 一维dp
         */
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int len = nums.length;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
            }
            // 奇数 返回false
            if (sum % 2 != 0) {
                return false;
            }

            // 定义dp[i][j] 表示对于前i个数据，能否凑成和未j  i从1开始
            boolean[] dp = new boolean[sum/2+1];
            // base case j=0时 都为true
            dp[0] = true;

            for (int i = 1; i <= len; i++) {
                for (int j = sum/2; j >= 0; j--) {
                    if (j - nums[i-1] >= 0) {
                        // 拿与不拿
                        dp[j] = dp[j] || dp[j-nums[i-1]];
                    }
                }
            }
            return dp[sum/2];

        }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
