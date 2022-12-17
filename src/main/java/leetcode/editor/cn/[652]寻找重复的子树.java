package leetcode.editor.cn;

import common.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
class Solution652 {

    private Map<String, Integer> allSubMap = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;

    }


    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        Integer subTreeNum = allSubMap.getOrDefault(subTree, 0);
        if (subTreeNum == 1) {
            result.add(root);
        }
        // 放入到map中
        allSubMap.put(subTree, subTreeNum + 1);
        return subTree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
