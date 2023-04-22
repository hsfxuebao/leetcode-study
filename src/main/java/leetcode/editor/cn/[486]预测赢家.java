package leetcode.editor.cn;

//给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。 
//
// 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0
//] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取
//时，游戏结束。 
//
// 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分
//数最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,2]
//输出：false
//解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
//如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）
//可选。 
//所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
//因此，玩家 1 永远不会成为赢家，返回 false 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,5,233,7]
//输出：true
//解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
//最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 10⁷ 
// 
//
// Related Topics递归 | 数组 | 数学 | 动态规划 | 博弈 
//
// 👍 620, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 预测赢家
 *
 * @author hsfxuebao
 * 2023-04-22 17:40:22 
 */
class P486_PredictTheWinner{
    public static void main(String[] args) {
        Solution solution = new P486_PredictTheWinner().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean PredictTheWinner(int[] nums) {

        int n = nums.length;
        // dp[i][j].fir = x 表示对于 piles[i...j] 这部分石头堆，先手能获得的最高分数为 x
        // dp[i][j].sec = x 表示对于 piles[i...j] 这部分石头堆，后手能获得的最高分数为 x
        Pair[][] dp = new Pair[n][n];
        // 初始化dp数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        // 状态转移方程    先拿左边，第二次拿就变成后手了， 先拿右边
        // dp[i][j].fir = max(piles[i]+ dp[i+1][j], dp[i][j-1]+piles[j])
        // 若先手拿左边，                       先手拿右边
        // dp[i][j].sec = dp[i+1][j].fir  或 dp[i][j-1].fir;

        // base case i==j 的情况
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = nums[i];
            dp[i][i].sec = 0;
        }

        for (int i = n-2; i >= 0 ; i--) {
            for (int j = i+1; j < n; j++) {
                // 先手拿左边
                int left = nums[i] + dp[i+1][j].sec;
                // 先手拿右边
                int right = nums[j] + dp[i][j-1].sec;

                // 判断大小
                if (left >= right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }

        return dp[0][n-1].fir >= dp[0][n-1].sec;
    }


    public class Pair {
        int fir; // 先手获得的分数
        int sec; // 后手获得的分数
        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
