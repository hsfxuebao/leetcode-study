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
class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val == key) {

            // 只有左子树 或者 右子树
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 含有左右子树
            // 找到右子树的最小节点
            TreeNode minNode = getRightMinNode(root.right);
            root.right = deleteNode(root.right, minNode.val);
            // 更换指针
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }
        return root;
    }


    private TreeNode getRightMinNode(TreeNode node) {

        // BST 最左边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
