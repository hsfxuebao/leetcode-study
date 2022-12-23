package other;

/**
 * 0-1背包问题
 *
 */
class BackPack {

    public int backPack(int m, int[] weight, int[] val) {
        int n = weight.length;
        int[][] dp = new int[n + 1][m + 1];

        // 初始值 都是0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (j - weight[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入 或 不装入背包 择优
                    dp[i][j] = Math.max(
                            dp[i - 1][j], dp[i - 1][j - weight[i-1]] + val[i-1]);

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
