package leetcode.editor.cn;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 2462, 👎 0 
//
//
//
//



import common.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * @author hsfxuebao
 * 2023-09-27 16:00:40 
 */
class P236_LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new P236_LowestCommonAncestorOfABinaryTree().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return find(root, p, q);
    }

    // 返回 p和q节点的 公共祖先
    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 若有一个值相等，返回当前值
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        // 左右子树 都不为null 返回root节点
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
