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
class Solution114 {

    /**
     * 分解问题
     * @param root
     */
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        // 左右
        flatten(root.left);
        flatten(root.right);
        // 将当前节点 的左右子树，全部 改成右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
