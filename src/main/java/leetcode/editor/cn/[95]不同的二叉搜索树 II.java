package leetcode.editor.cn;
import java.util.ArrayList;
import java.util.List;

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
class Solution {

    public List<TreeNode> generateTrees(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }
        return buildBST(1, n);
    }

    private List<TreeNode> buildBST(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            // 以i 为root节点
            List<TreeNode> leftNodes = buildBST(left, i - 1);
            List<TreeNode> rightNodes = buildBST(i + 1, right);

            // 遍历所有 左右子树，构建节点
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
