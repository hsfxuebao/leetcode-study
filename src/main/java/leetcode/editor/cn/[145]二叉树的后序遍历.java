package leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1098, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.List;


import common.TreeNode;

/**
 * 二叉树的后序遍历
 *
 * @author hsfxuebao
 * 2023-09-25 20:50:07 
 */
class P145_BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P145_BinaryTreePostorderTraversal().new Solution();
        
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
    // 递归
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal1(TreeNode root) {

        traceback(root);
        return result;
    }

    private void traceback(TreeNode root) {
        if (root == null) {
            return;
        }
        traceback(root.left);
        traceback(root.right);
        result.add(root.val);
    }

    /**
     * 分解子问题
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> leftList = postorderTraversal(root.left);
        res.addAll(leftList);
        List<Integer> rightList = postorderTraversal(root.right);
        res.addAll(rightList);
        res.add(root.val);
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
 
}
