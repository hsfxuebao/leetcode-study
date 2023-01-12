package leetcode.editor.cn;

//给定一个整数 n ，返回 n! 结果中尾随零的数量。 
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
// 
//
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 104 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
// Related Topics 数学 
// 👍 739 👎 0

/**
 * 阶乘后的零
 *
 * @author hsfxuebao
 * 2023-01-12 10:18:40 
 */
class P172_FactorialTrailingZeroes{
    public static void main(String[] args) {
        Solution solution = new P172_FactorialTrailingZeroes().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int trailingZeroes1(int n) {
        int res = 0;
        int divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
        public int trailingZeroes(int n) {
            int res = 0;
            for (int d = n; d / 5 > 0; d = d / 5) {
                res += d / 5;
            }
            return res;
        }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
