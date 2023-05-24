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
// 👍 1868, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author hsfxuebao
 * 2023-05-20 16:48:09 
 */
class P28_FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        Solution solution = new P28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        /**
         * 字符串匹配算法 使用进制和 取模（计算匹配字符传的数值）
         */
        public int strStr(String haystack, String needle) {
            int N = haystack.length();
            int L = needle.length();

            // 取一个比较大的素数作为求模的除数
            long Q = 1658598167;

            int R = 256;
            // 计算R ^(L-1)的值
            long RL = 1;
            for (int i = 0; i < L-1; i++) {
                RL = (RL * R) % Q;
            }

            // 计算匹配串的 hash值
            long needHash = 0;
            for (int i = 0; i < L; i++) {
                needHash = ((R * needHash) % Q + needle.charAt(i)) % Q;
            }

            long windowHash = 0;

            int left = 0, right = 0;
            while (right < N) {
                // 计算窗口内的hash值
                windowHash = ((R * windowHash) % Q + haystack.charAt(right)) % Q;
                right++;

                while (right - left == L) {

                    // 计算是否匹配
                    if (needHash == windowHash) {
                        // 取模运算  再次匹配
                        if (needle.equals(haystack.subSequence(left, left + L))) {
                            return left;
                        }
                    }

                    // 左移动窗口 todo +Q 防止出现负数
                    windowHash = (windowHash - (RL * haystack.charAt(left)) % Q + Q) % Q;
                    left++;
                }
            }
            return -1;
        }

        /**
         * 字符串匹配算法 KMP算法
         */
    public int strStr1(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();

        // 计算匹配 的dp数组
        int[][] dp = new int[M][256];
        // base case
        dp[0][needle.charAt(0)] = 1;

        // 前缀匹配的字符
        int X = 0;
        // j的状态从 1开始
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                // 字符匹配
                if (needle.charAt(j) == c) {
                    dp[j][c] = j + 1;
                } else {
                    // 不匹配 回退到某个位置
                    dp[j][c] = dp[X][c];
                }
            }
            // 更新X
            X = dp[X][needle.charAt(j)];
        }

        // 根据dp匹配
        // pat的初始状态
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][haystack.charAt(i)];
            if (j == M) {
                return i - M +1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
