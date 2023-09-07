package leetcode.editor.cn;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
//
// Related Topics数学 | 动态规划 | 组合数学 
//
// 👍 1761, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 不同路径
 *
 * @author hsfxuebao
 * 2023-05-11 19:33:51 
 */
class P62_UniquePaths{
    public static void main(String[] args) {
        Solution solution = new P62_UniquePaths().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 动态规划 状态  base 选择 二维dp
         */
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        // 以dp(i,j) 到右下角有多少种路径
        int[][] dp = new int[m][n];

        // base case
        // 最后一行
        for (int j = 0; j < n-1; j++) {
            dp[m-1][j] = 1;
        }
        // 最后一列
        for (int i = 0; i < m-1; i++) {
            dp[i][n-1] = 1;
        }
        // 状态转移方程
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
