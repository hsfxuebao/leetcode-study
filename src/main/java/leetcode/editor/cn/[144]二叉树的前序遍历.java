package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1027, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * 二叉树的前序遍历
 *
 * @author hsfxuebao
 * 2023-03-21 20:56:30 
 */
class P144_BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();
        
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
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 左右子节点
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }


    /**
     * 递归
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
