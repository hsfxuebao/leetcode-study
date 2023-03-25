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
// 👍 757, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

/**
 * 最长同值路径
 *
 * @author hsfxuebao
 * 2023-03-16 09:40:56 
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
        maxLen(root, root.val);
        return res;

    }

    // 定义：计算以 root 为根的这棵⼆叉树中，从 root 开始值为 parentVal 的最⻓树枝⻓
    //度
    private int maxLen(TreeNode root, int parentVal) {

        if (root == null) {
            return 0;
        }
        int leftLen = maxLen(root.left, root.val);
        int rightLen = maxLen(root.right, root.val);
        // 更新res
        res = Math.max(res, leftLen + rightLen);
        if (root.val != parentVal) {
            return 0;
        }
        return 1 + Math.max(leftLen, rightLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
