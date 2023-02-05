package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1485, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;
import org.omg.CORBA.ServiceInformationHelper;


/**
 * 二叉树的最大深度
 *
 * @author hsfxuebao
 * 2023-02-05 12:28:31 
 */
class P104_MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
        
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

    /**
     * 动态规划，分解子问题
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    /**
     * 回溯算法，递归
     */
    int result = 0;
    int depth = 0;
    public int maxDepth1(TreeNode root) {
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }
        // 前序遍历位置
        depth++;
        result = Math.max(result, depth);
        // 遍历的过程中记录最⼤深度
        traverse(root.left);
        traverse(root.right);

        // 后续遍历位置
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
