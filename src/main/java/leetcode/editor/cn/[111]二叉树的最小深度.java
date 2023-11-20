package leetcode.editor.cn;

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1125, 👎 0 
//
//
//
//

import java.util.LinkedList;
import java.util.Queue;


import common.TreeNode;

/**
 * 二叉树的最小深度
 *
 * @author hsfxuebao
 * 2023-11-20 16:03:34 
 */
class P111_MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
        
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
    public int minDepth(TreeNode root) {
        // 层序遍历
//        return minDepthLevel(root);
        // 分解问题
        return minDepthIter(root);
    }

    int depth = 0;
    private int minDepthIter(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDep = minDepthIter(root.left);
        int rightDep = minDepthIter(root.right);

        // 返回最小深度
        // 有两种情况，有可能 其中一个节点为null，此时应该为 leftDep+rightDep+1;
        // 如果左右节点都不为空，此时为Math.min(leftDep,rightDep)+1;
        return root.left == null || root.right == null
                ? leftDep+rightDep+1
                : Math.min(leftDep, rightDep) + 1;
    }

    private int minDepthLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
