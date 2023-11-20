package leetcode.editor.cn;

//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 字符串 | 回溯 | 二叉树 
//
// 👍 1067, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import common.TreeNode;

/**
 * 二叉树的所有路径
 *
 * @author hsfxuebao
 * 2023-11-20 16:17:53 
 */
class P257_BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new P257_BinaryTreePaths().new Solution();
        
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
    List<String> res = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        // 回溯算法
        backtrack(root, track);
        // 对result结果进行处理
        for (List<Integer> list : result) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append("->");
                }
            }
            res.add(sb.toString());
        }
        return res;

    }

    private void backtrack(TreeNode root, LinkedList<Integer> track) {
        if (root == null) {
            return;
        }


        // 选择集
        track.add(root.val);
        backtrack(root.left, track);
        backtrack(root.right, track);
        // 后续遍历位置 离开节点的时候
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(track));
        }
        track.removeLast();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
