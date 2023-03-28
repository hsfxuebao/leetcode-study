package leetcode.editor.cn;

//给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。 
//
// 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。 
//
// 也就是说，你需要重复此过程直到不能继续删除。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [1,2,3,2,null,2,4], target = 2
//输出：[1,null,3,null,4]
//解释：
//上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
//有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [1,3,3,3,2], target = 3
//输出：[1,3,null,null,2]
// 
//
// 示例 3： 
//
// 
//
// 输入：root = [1,2,null,2,null,2], target = 2
//输出：[1]
//解释：每一步都删除一个绿色的叶子节点（值为 2）。 
//
// 示例 4： 
//
// 输入：root = [1,1,1], target = 1
//输出：[]
// 
//
// 示例 5： 
//
// 输入：root = [1,2,3], target = 1
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 1000 
// 每一棵树最多有 3000 个节点。 
// 每一个节点值的范围是 [1, 1000] 。 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 104, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

/**
 * 删除给定值的叶子节点
 *
 * @author hsfxuebao
 * 2023-03-27 21:41:20 
 */
class P1325_DeleteLeavesWithAGivenValue{
    public static void main(String[] args) {
        Solution solution = new P1325_DeleteLeavesWithAGivenValue().new Solution();
        
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        // 后序位置  判断是否要删除自己
        // 叶子节点 & 等于target
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
