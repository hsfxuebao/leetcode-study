package leetcode.editor.cn;

//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics双指针 | 字符串 | 字符串匹配 
//
// 👍 1713, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author hsfxuebao
 * 2023-01-31 17:59:18 
 */
class P28_FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        Solution solution = new P28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {

        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

}

    class KMP {

        private int[][] dp;
        private String pat;

        public KMP(String pat) {
            this.pat = pat;
            int M = pat.length();
            // dp[状态][字符] = 下一个状态
            dp = new int[M][256];
            // base case
            dp[0][pat.charAt(0)] = 1;
            // 影子状态初始 为0
            int X = 0;
            // 构建状态转移图
            for (int j = 1; j < M; j++) {
                for (int c = 0; c < 256; c++) {
                    dp[j][c] = dp[X][c];
                }
                // 前进一步
                dp[j][pat.charAt(j)] = j+1;
                // 更新影子状态
                X = dp[X][pat.charAt(j)];
            }


        }

        public int search(String text) {
            int M = pat.length();
            int N = text.length();
            // pat的初始状态为0
            int j = 0;
            for (int i = 0; i < N; i++) {
                // 计算 pat 的下一个状态
                j = dp[j][text.charAt(i)];
                // 到达终止态，返回结果
                if (j == M) {
                    return i - M + 1;
                }
            }
            return -1;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)
 
}
