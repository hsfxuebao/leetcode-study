package leetcode.editor.cn;

//给你一棵二叉搜索树的
// root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,7]
//输出：[1,null,5,null,7]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的取值范围是 [1, 100] 
// 0 <= Node.val <= 1000 
// 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 330, 👎 0 
//
//
//
//

import common.TreeNode;

/**
 * 递增顺序搜索树
 *
 * @author hsfxuebao
 * 2023-09-25 17:34:05 
 */
class P897_IncreasingOrderSearchTree{
    public static void main(String[] args) {
        Solution solution = new P897_IncreasingOrderSearchTree().new Solution();
        
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

    /**
     *  递归，中序遍历，然后在一个一个链接数据
     *  分解子问题，
     * @param root
     * @return
     */
    // 返回 展开成链表的头结点
    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = increasingBST(root.left);
        TreeNode right = increasingBST(root.right);
        root.left = null;
        root.right = right;
        // 判断左子树 是否为空
        if (left == null) {
            return root;
        }
        // 需要将根节点和right 节点 放到左子树的左右节点的下面
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }

        p.right = root;
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
