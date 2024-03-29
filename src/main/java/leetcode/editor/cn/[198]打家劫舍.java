package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 2537, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 打家劫舍
 *
 * @author hsfxuebao
 * 2023-04-18 21:18:26 
 */
class P198_HouseRobber{
    public static void main(String[] args) {
        Solution solution = new P198_HouseRobber().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
       //
//        return rob1(nums);
        return rob2(nums);
    }

        private int rob2(int[] nums) {
            int pre = 0, pre2 = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(pre, pre2+nums[i]);
                pre2 = pre;
                pre = res;
            }
            return res;
        }


        private int rob1(int[] nums) {
            int[] dp = new int[nums.length+2];
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-2]);
            }
            return dp[nums.length+1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
