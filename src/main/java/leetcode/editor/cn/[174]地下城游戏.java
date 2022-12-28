package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 动态规划
     * 二维dp
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null) {
            return 0;
        }

        int row = dungeon.length;
        int col = dungeon[0].length;

        // 表示从dp[i][j] 到最后一个位置的 最少生命值
        int[][] dp = new int[row][col];
        // base case
        dp[row - 1][col - 1] = dungeon[row - 1][col - 1] >= 0
                               ? 1 : -dungeon[row - 1][col - 1] + 1;
        // 最后一列
        for (int i = row - 2; i >= 0; i--) {
            int res = dp[i + 1][col - 1] - dungeon[i][col - 1];
            dp[i][col - 1] = res <= 0 ? 1 : res;
        }
        // 最后一行
        for (int j = col - 2; j >= 0; j--) {
            int res = dp[row - 1][j + 1] - dungeon[row - 1][j];
            dp[row - 1][j] = res <= 0 ? 1 : res;
        }


        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = res <= 0 ? 1 : res;
            }
        }
        return dp[0][0];
    }

//    public static void main(String[] args) {
//        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
//        new Solution().calculateMinimumHP(nums);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
