package leetcode.editor.cn;

//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics树 | 二叉搜索树 | 动态规划 | 回溯 | 二叉树 
//
// 👍 1406, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * 不同的二叉搜索树 II
 *
 * @author hsfxuebao
 * 2023-03-30 21:09:13 
 */
class P95_UniqueBinarySearchTreesIi{
    public static void main(String[] args) {
        Solution solution = new P95_UniqueBinarySearchTreesIi().new Solution();
        
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

    public List<TreeNode> generateTrees(int n) {

        if (n <= 0) {
            return null;
        }
        return buildTree(1, n);

    }

    // 构建[lo,hi]闭区间的树
    private List<TreeNode> buildTree(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();

        if (lo > hi) {
            res.add(null);
            return res;
        }

        // 穷举root节点的所有可能
        for (int i = lo; i <= hi; i++) {
            // 以i 为root节点
            List<TreeNode> leftNode = buildTree(lo, i-1);
            List<TreeNode> rightNode = buildTree(i+1, hi);

            for (TreeNode left:leftNode) {
                for (TreeNode right:rightNode) {

                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
