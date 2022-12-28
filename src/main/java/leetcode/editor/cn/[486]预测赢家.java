package leetcode.editor.cn;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution486 {

    /**
     * 博弈问题 动态规划
     * 二维dp
     */
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return true;
        }
        int m = nums.length;
        Pair[][] dp = new Pair[m][m];
        // base case: 斜着
        for (int i = 0; i < m; i++) {
            dp[i][i] = new Pair(nums[i], 0);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                // 第一个人 拿 左边
                int left = nums[i] + dp[i + 1][j].second;
                int right = nums[j] + dp[i][j - 1].second;

                // 第二个人拿
                if (left >= right) {
                    int second = dp[i + 1][j].first;
                    dp[i][j] = new Pair(left, second);
                } else {
                    int second = dp[i][j - 1].first;
                    dp[i][j] = new Pair(right, second);
                }
            }
        }
        Pair result = dp[0][m - 1];
        return result.first >= result.second;

    }

    public class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
