package leetcode.editor.cn;

//给你一个有根节点
// root 的二叉树，返回它 最深的叶节点的最近公共祖先 。 
//
// 回想一下： 
//
// 
// 叶节点 是二叉树中没有子节点的节点 
// 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1 
// 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：我们返回值为 2 的节点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的节点。
//注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[1]
//解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
// 
//
// 示例 3： 
//
// 
//输入：root = [0,1,3,null,2]
//输出：[2]
//解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数将在
// [1, 1000] 的范围内。 
// 0 <= Node.val <= 1000 
// 每个节点的值都是 独一无二 的。 
// 
//
// 
//
// 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-
//the-deepest-nodes/ 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 哈希表 | 二叉树 
//
// 👍 139, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

/**
 * 最深叶节点的最近公共祖先
 *
 * @author hsfxuebao
 * 2023-02-07 09:57:23 
 */
class P1123_LowestCommonAncestorOfDeepestLeaves{
    public static void main(String[] args) {
        Solution solution = new P1123_LowestCommonAncestorOfDeepestLeaves().new Solution();
        
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        Result res = maxDepth(root);
        return res.node;
    }

    private Result maxDepth(TreeNode root) {

        if (root == null) {
            return new Result(null, 0);
        }
        // 左右子节点
        Result leftNode = maxDepth(root.left);
        Result rightNode = maxDepth(root.right);

        // 当左右子节点的最大深度相同时，这个根节点就是最近公共祖先
        //
        if (leftNode.depth == rightNode.depth) {
            return new Result(root, leftNode.depth+1);
        }
        // 左右子树 最大深度不同时，最近公共祖先在 depth较大的 那个里面
        Result res = leftNode.depth > rightNode.depth ? leftNode : rightNode;
        res.depth++;
        return res;
    }

    class Result {

        // // 记录最近公共祖先节点 node
        private TreeNode node;
        // 记录以node为根 的二叉树最大深度
        private int depth;

        public Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
