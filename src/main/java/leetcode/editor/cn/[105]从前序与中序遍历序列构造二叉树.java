package leetcode.editor.cn;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 1861, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author hsfxuebao
 * 2023-02-09 09:41:47 
 */
class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        
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
    private Map<Integer, Integer> inVal2IndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inVal2IndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length - 1);

    }

    /**
        定义：前序遍历数组为 preorder[preStart..preEnd]，
        中序遍历数组为 inorder[inStart..inEnd]，
        构造这个⼆叉树并返回该⼆叉树的根节点
    */
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int inIndex = inVal2IndexMap.get(rootVal);
        int leftLen = inIndex - inStart;

        // 构造当前跟节点
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart+1, preStart+leftLen, inorder, inStart, inIndex-1);
        root.right = buildTree(preorder, preStart+leftLen+1, preEnd, inorder, inIndex+1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
