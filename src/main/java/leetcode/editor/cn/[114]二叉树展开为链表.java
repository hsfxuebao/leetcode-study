package leetcode.editor.cn;

//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 链表 | 二叉树 
//
// 👍 1422, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

/**
 * 二叉树展开为链表
 *
 * @author hsfxuebao
 * 2023-03-21 21:07:23 
 */
class P114_FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
        Solution solution = new P114_FlattenBinaryTreeToLinkedList().new Solution();
        
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
     * 分解子问题
     * 将以root 为根节点的 拉平成 链表
     */
    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // 将 左右子树 拉平成链表
        flatten(root.left);
        flatten(root.right);
        // 后序位置
        // 1.左右子树 已经被拉平成链表了
        TreeNode right = root.right;
        TreeNode left = root.left;
        // 2. 将左子树 做成 右子树
        // 将root的左子树 全部 放到右子树下
        root.left = null;
        root.right = left;
        // 3. 将原先右子树 放到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
