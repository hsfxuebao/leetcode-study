package leetcode.editor.cn;

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics树 | 二叉搜索树 | 数学 | 动态规划 | 二叉树 
//
// 👍 2176, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 不同的二叉搜索树
 *
 * @author hsfxuebao
 * 2023-03-29 09:50:10 
 */
class P96_UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        return count(1, n);
    }

        /* 计算闭区间 [lo, hi] 组成的 BST 个数 */
        private int count(int left, int right) {

            if (left > right) {
                return 1;
            }
            int result = 0;
            for (int i = left; i <= right; i++) {
                // 以i 为根节点的
                int leftNum = count(left, i - 1);
                int rightNum = count(i+1, right);
                // 左右子树的组合数乘积是 BST 的总数
                result += leftNum * rightNum;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
