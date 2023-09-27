package leetcode.editor.cn;

//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1705, 👎 0 
//
//
//
//

import static com.sun.org.apache.xerces.internal.impl.xs.opti.SchemaDOM.traverse;


import common.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @author hsfxuebao
 * 2023-09-23 16:02:43 
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

    // 动态规划思路，分解子问题
    public int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);

        int curDepth = Math.max(leftDepth, rightDepth) + 1;
        return curDepth;
    }
    // 回溯，遍历
    int maxDepth = Integer.MIN_VALUE;
    int depth = 0;
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        trackback(root);
        return maxDepth;

    }

    private void trackback(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        maxDepth = Math.max(maxDepth, depth);

        trackback(root.left);
        trackback(root.right);
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
