package leetcode.editor.cn;

//给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 758, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

/**
 * 最长同值路径
 *
 * @author hsfxuebao
 * 2023-03-27 21:20:43 
 */
class P687_LongestUnivaluePath{
    public static void main(String[] args) {
        Solution solution = new P687_LongestUnivaluePath().new Solution();
        
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
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return res;
        }
        maxLength(root, root.val);
        return res;

    }

    private int maxLength(TreeNode root, long parentVal) {
        if (root == null) {
            return 0;
        }
        int leftVal = maxLength(root.left, root.val);
        int rightVal = maxLength(root.right, root.val);
        res = Math.max(res, leftVal + rightVal);
        // 当前节点的 最大同值路径
        if (root.val != parentVal) {
            return 0;
        }
        return Math.max(leftVal, rightVal) + 1;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
