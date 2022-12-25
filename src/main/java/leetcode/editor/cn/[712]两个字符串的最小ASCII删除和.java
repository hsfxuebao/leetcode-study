package leetcode.editor.cn;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.model.core.ID;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m][n];
        // 初始化为-1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumSum(s1, 0, s2, 0);

    }

    private int minimumSum(String s1, int i, String s2, int j) {
        int res = 0;
        // base case
        if (i == s1.length()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;

        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            dp[i][j] = minimumSum(s1, i + 1, s2, j+1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            dp[i][j] =  Math.min(s1.charAt(i) + minimumSum(s1, i+1, s2, j),
                    s2.charAt(j) + minimumSum(s1, i, s2, j+1));
        }
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
