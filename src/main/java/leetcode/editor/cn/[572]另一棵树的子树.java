package leetcode.editor.cn;

//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
// 
// 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 | 字符串匹配 | 哈希函数 
//
// 👍 887, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

/**
 * 另一棵树的子树
 *
 * @author hsfxuebao
 * 2023-03-25 20:31:44 
 */
class P572_SubtreeOfAnotherTree{
    public static void main(String[] args) {
        Solution solution = new P572_SubtreeOfAnotherTree().new Solution();
        
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        // 当前节点
        if (isSamTree(root, subRoot)) {
            return true;
        }
        // 左右子节点
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);

    }

    private boolean isSamTree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isSamTree(root.left, subRoot.left) && isSamTree(root.right, subRoot.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
