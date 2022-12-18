package leetcode.editor.cn;
import java.util.Objects;

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
class Solution98 {
    /**
     * 当前节点 的值  大于 左子树的所有节点值
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isValidBST(root, null, null);

    }
    /**
     *  限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     */
    public boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        // base case
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (Objects.nonNull(minNode) && minNode.val >= root.val) {
            return false;
        }
        if (Objects.nonNull(maxNode) && maxNode.val <= root.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, minNode, root)
                && isValidBST(root.right, root, maxNode);

    }


}
//leetcode submit region end(Prohibit modification and deletion)
