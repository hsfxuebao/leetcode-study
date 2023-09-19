package leetcode.editor.cn;

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics哈希表 | 数学 | 动态规划 | 堆（优先队列） 
//
// 👍 1108, 👎 0 
//
//
//
//

/**
 * 丑数 II
 *
 * @author hsfxuebao
 * 2023-09-18 14:25:42 
 */
class P264_UglyNumberIi{
    public static void main(String[] args) {
        Solution solution = new P264_UglyNumberIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        // 对应质数 数组中的索引
        int p2 = 1, p3 = 1, p5 = 1;
        // 分别对应三个的值
        int num2 = 1, num3 = 1, num5 = 1;
        int[] ugly = new int[n+1];
        int p = 1;
        while (p <= n) {

            int min = Math.min(Math.min(num2, num3), num5);
            ugly[p] = min;
            p++;
            if (min == num2) {
                num2 = ugly[p2] * 2;
                p2++;
            }
            if (min == num3) {
                num3 = ugly[p3] * 3;
                p3++;
            }
            if (min == num5) {
                num5 = ugly[p5] * 5;
                p5++;
            }
        }
        return ugly[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
