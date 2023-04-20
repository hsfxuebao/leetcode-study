package other;

/**
 * 0-1背包问题
 *
 */
class BackPack {

    public int backPack(int m, int[] weight, int[] val) {

        int n = weight.length;
        // dp[i][j] 为 第i个物品，背包重量为j,可获得的最大价值
        // i 从1 开始
        int[][] dp = new int[n+1][m+1];
        // base case 都是0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - weight[i - 1] < 0) {
                    // 拿 与 不拿 去最大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+val[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        int m = 10;
        int[] weight = {2, 3, 5, 7};
        int[] val = {1, 5, 2, 4};

        int result = new BackPack().backPack(m, weight, val);
        System.out.println(result);
    }
}
