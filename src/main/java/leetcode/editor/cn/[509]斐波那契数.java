package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution509 {

    private int[] dp;

    /**
     * 备忘录的dp数组
     */
    public int fib1(int n) {

        if (n <= 0) {
            return 0;
        }
        dp = new int[n + 1];

        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }

    /**
     * 优化，由于 状态方程 值使用了 n-1 和n-2 这两个数
     */
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        int cur = 1;
        int pre2 = 0;
        int pre1 = 1;
        for (int i = 2; i <= n; i++) {
            cur = pre1 + pre2;
            // 更新
            pre2 = pre1;
            pre1 = cur;
        }

        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
