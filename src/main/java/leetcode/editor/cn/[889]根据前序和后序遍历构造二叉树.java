package leetcode.editor.cn;

//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 330, 👎 0 
//
//
//
//

import java.util.HashMap;
import java.util.Map;


import common.TreeNode;

/**
 * 根据前序和后序遍历构造二叉树
 *
 * @author hsfxuebao
 * 2023-11-22 19:40:45 
 */
class P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        
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
    Map<Integer, Integer> postOrderMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length; i++) {
            postOrderMap.put(postorder[i], i);
        }
        return constructFromPrePost(preorder, 0, preorder.length -1, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {

        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preEnd]);
        }
        // 根节点
        int nodeVal = preorder[preStart];

        // 左子树节点
        // todo preStart 必须小于preEnd 不能等于
        int leftNodeVal = preorder[preStart+1];
        // 左子树节点对应的位置
        int index = postOrderMap.get(leftNodeVal);
        // 左子树的长度
        int leftLen = index - postStart;
        TreeNode node = new TreeNode(nodeVal);
        node.left = constructFromPrePost(preorder, preStart+1, preStart+leftLen+1, postorder, postStart, postStart+leftLen);
        node.right = constructFromPrePost(preorder, preStart+leftLen+1+1, preEnd, postorder, postStart+leftLen+1, postEnd-1);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
