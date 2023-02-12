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
// 👍 296, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

import javax.swing.event.TreeExpansionEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序和后序遍历构造二叉树
 *
 * @author hsfxuebao
 * 2023-02-12 14:54:32 
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
    private Map<Integer, Integer> postVal2IndexMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length - 1; i++) {
            
            postVal2IndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root 节点对应的值就是前序遍历数组的第⼀个元素
        int rootVal = preorder[preStart];
        // root.left 的值是前序遍历第⼆个元素
        // 通过前序和后序遍历构造⼆叉树的关键在于通过左⼦树的根节点
        // 确定 preorder 和 postorder 中左右⼦树的元素区间
        int leftRootVal = preorder[preStart + 1];
        // 找到 左子树对应的 索引
        Integer leftRootIndex = postVal2IndexMap.get(leftRootVal);
        // 左子树的长度
        int leftLen = leftRootIndex - postStart + 1;

        //
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart+1, preStart + leftLen,
                postorder, postStart, leftRootIndex);
        root.right = buildTree(preorder, preStart + leftLen + 1, preEnd,
                postorder, leftRootIndex+1, preEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
