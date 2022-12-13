package leetcode.editor.cn;
import common.TreeNode;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1448 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 二叉树 一般解法 2种，一种是遍历 借助外部变量，另一种是 分解子问题
 */
class Solution104 {


    int result;
    int depth;
    public int maxDepth(TreeNode root) {

        /**
         * 遍历+外部变量
         * 回溯算法
         */
//        traverse(root);
//        return result;
        /**
         * 分解子问题
         * 动态规划
         */
        // base case
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private void traverse(TreeNode root) {
        // base  case
        if (root == null) {
            return;
        }
        // 前序的位置
        depth++;
        // 判断是否 是叶子节点
        if (root.left == null && root.right == null) {
            result = Math.max(depth, result);
        }

        // 左右遍历
        traverse(root.left);
        traverse(root.right);

        // 离开的位置
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
