package leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1530, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

/**
 * 翻转二叉树
 *
 * @author hsfxuebao
 * 2023-03-22 19:06:00 
 */
class P226_InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P226_InvertBinaryTree().new Solution();
        
    }  
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
class Solution {

    // 分解子问题，以root为根节点 二叉树翻转，返回翻转后的二叉树的根节点
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree1(root.left);
        TreeNode rightNode = invertTree1(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    // 递归
    public TreeNode invertTree(TreeNode root) {
        trackback(root);
        return root;
    }

    private void trackback(TreeNode root) {
        if (root == null) {
            return;
        }
        // 更换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        trackback(root.left);
        trackback(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
