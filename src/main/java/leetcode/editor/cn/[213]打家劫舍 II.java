package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1338, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 打家劫舍 II
 *
 * @author hsfxuebao
 * 2023-04-18 21:21:50 
 */
class P213_HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new P213_HouseRobberIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int m = nums.length;
        if (m == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, m-2), rob(nums, 1, m-1));

    }

        private int rob(int[] nums, int start, int end) {

            int pre = 0, pre2 = 0;
            int res = 0;
            for (int i = start; i <= end ; i++) {
                res = Math.max(pre2 + nums[i], pre);
                pre2 = pre;
                pre = res;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
