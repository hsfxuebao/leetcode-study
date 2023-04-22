package leetcode.editor.cn;

//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1904 👎 0

/**
 * 跳跃游戏 II
 *
 * @author hsfxuebao
 * 2023-01-01 11:06:27 
 */
class P45_JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new P45_JumpGameIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 贪心算法
         * 每次 都取最大的
         */
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int farthest = 0;
        int jump = 0;
        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if (i == end) {
                end = farthest;
                jump++;
            }
        }
        return jump;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
