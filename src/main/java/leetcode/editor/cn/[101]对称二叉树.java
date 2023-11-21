package leetcode.editor.cn;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 2591, 👎 0 
//
//
//
//

import java.util.LinkedList;
import java.util.Queue;


import common.TreeNode;

/**
 * 对称二叉树
 *
 * @author hsfxuebao
 * 2023-11-21 16:43:15 
 */
class P101_SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new P101_SymmetricTree().new Solution();
        
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
    public boolean isSymmetric(TreeNode root) {
        // 递归
//        return isSymmetricRec(root, root);
        // 迭代
        return isSymmetricIter(root, root);
    }

    private boolean isSymmetricIter(TreeNode pNode, TreeNode qNode) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pNode);
        queue.offer(qNode);

        while (!queue.isEmpty()) {

            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }

            // 加入队列
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }

    private boolean isSymmetricRec(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSymmetricRec(p.left, q.right)
                && isSymmetricRec(p.right, q.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
