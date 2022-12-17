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
class Solution538 {

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    //
    int sum = 0;
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.right);
        sum += root.val;
        root.val = sum;

        traverse(root.left);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
