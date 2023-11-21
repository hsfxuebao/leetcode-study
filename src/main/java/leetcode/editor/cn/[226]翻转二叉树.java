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
// 👍 1734, 👎 0 
//
//
//
//

import common.TreeNode;

/**
 * 翻转二叉树
 *
 * @author hsfxuebao
 * 2023-11-21 18:57:22 
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
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        backtrack(root);
        return root;

    }

    private TreeNode backtrack(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = backtrack(root.left);
        TreeNode right = backtrack(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
