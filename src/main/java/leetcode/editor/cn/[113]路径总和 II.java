package leetcode.editor.cn;

//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 回溯 | 二叉树 
//
// 👍 1060, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import common.TreeNode;

/**
 * 路径总和 II
 *
 * @author hsfxuebao
 * 2023-11-23 14:56:53 
 */
class P113_PathSumIi{
    public static void main(String[] args) {
        Solution solution = new P113_PathSumIi().new Solution();
        
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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(root, track, targetSum);
        return res;
    }

    private void backtrack(TreeNode root, LinkedList<Integer> track, int target) {

        if (root == null) {
            return;
        }

        track.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(track));
            // todo 不能写return
//            return;
        }
        // 选择集
        // 左边和右边
        backtrack(root.left, track, target);
        backtrack(root.right, track, target);
        track.removeLast();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
