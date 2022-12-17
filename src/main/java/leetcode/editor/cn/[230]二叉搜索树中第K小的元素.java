package leetcode.editor.cn;

import common.TreeNode;
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
class Solution230 {

    int result;
    int numSort = 0;

    // 中序遍历
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        // 左子树
        traverse(root.left, k);
        numSort++;
        if (numSort == k) {
            result = root.val;
            return;
        }
        // 右子树
        traverse(root.right, k);


    }
}
//leetcode submit region end(Prohibit modification and deletion)
