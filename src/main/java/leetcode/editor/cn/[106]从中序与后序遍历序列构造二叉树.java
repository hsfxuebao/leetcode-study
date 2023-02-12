package leetcode.editor.cn;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 930, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author hsfxuebao
 * 2023-02-10 09:48:20 
 */
class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inVal2IndexMap.put(inorder[i], i);
        }
        TreeNode treeNode = buildTree(inorder, 0, inorder.length - 1, 
                postorder, 0, postorder.length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = postorder[postEnd];
        // 中序 中找到  root节点
        Integer inIndex = inVal2IndexMap.get(rootVal);
        // 左子树 长度
        int leftLen = inIndex - inStart;
        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = buildTree(inorder, inStart, inIndex - 1, postorder, postStart, postStart+leftLen-1);
        rootNode.right = buildTree(inorder, inIndex+1, inEnd, postorder, postStart+leftLen, postEnd-1);
        return rootNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
