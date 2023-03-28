package leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，返回所有 重复的子树 。 
//
// 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。 
//
// 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在 [1, 5000] 范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics树 | 深度优先搜索 | 哈希表 | 二叉树 
//
// 👍 674, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.TreeNode;

/**
 * 寻找重复的子树
 *
 * @author hsfxuebao
 * 2023-03-27 21:50:08 
 */
class P652_FindDuplicateSubtrees{
    public static void main(String[] args) {
        Solution solution = new P652_FindDuplicateSubtrees().new Solution();
        
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
    Map<String, Integer> memo  = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if (root == null) {
            return result;
        }
        traverse(root);
        return result;

    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = traverse(root.left);
        String rightStr = traverse(root.right);
        // 后序位置 当前树的结构
        String rootStr = leftStr +"," + rightStr + "," + root.val;
        Integer rootVal = memo.getOrDefault(rootStr, 0);
        if (rootVal == 1) {
            result.add(root);
        }
        memo.put(rootStr, rootVal + 1);
        return rootStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
