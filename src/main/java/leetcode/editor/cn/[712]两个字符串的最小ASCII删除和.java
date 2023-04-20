package leetcode.editor.cn;

//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 316, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;

/**
 * 两个字符串的最小ASCII删除和
 *
 * @author hsfxuebao
 * 2023-04-18 20:23:27 
 */
class P712_MinimumAsciiDeleteSumForTwoStrings{
    public static void main(String[] args) {
        Solution solution = new P712_MinimumAsciiDeleteSumForTwoStrings().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        dp = new int[m][n];
        for (int[] atr:dp) {
            Arrays.fill(atr, -1);
        }
        return minimumDelete(s1, 0, s2, 0);

    }

        // 定义dp[i][j] i到结尾，j到结尾 中最小删除元素的ASCII和
        private int minimumDelete(String s1, int i, String s2, int j) {

            int res = 0;
            // s1结束
            if (i == s1.length()) {
                for (int k = j; k < s2.length(); k++) {
                    res += s2.charAt(k);
                }
                return res;
            }
            // s2结束
            if (j == s2.length()) {
                for (int k = i; k < s1.length(); k++) {
                    res += s1.charAt(k);
                }
                return res;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }

            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = minimumDelete(s1, i + 1, s2, j + 1);
            } else {
                dp[i][j] = Math.min(s1.charAt(i) + minimumDelete(s1, i + 1, s2, j),
                        s2.charAt(j) + minimumDelete(s1, i, s2, j+1));
            }
            return dp[i][j];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
