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
class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }


    private TreeNode build(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        // 找到从left 到right的最大值 以及对应索引
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if (maxValue <= nums[i]) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        // 构造根节点
        TreeNode node = new TreeNode(maxValue);
        // 递归调用构造 左右 子节点
        node.left = build(nums, left, maxIndex - 1);
        node.right = build(nums, maxIndex + 1, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
