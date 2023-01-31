package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 732, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author hsfxuebao
 * 2023-01-30 19:42:29 
 */
class P103_BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
        
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

    /**
     * BFS
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 每层遍历方向
        // 为 true 时向右，false 时向左
        boolean flag = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // while 循环控制从上向下⼀层层遍历
        while(!queue.isEmpty()){

            int levelSize = queue.size();
            // 记录这⼀层的节点值
            LinkedList<Integer> level = new LinkedList<>();
            // for 循环控制每⼀层从左向右遍历
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (flag) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 改变方向
            flag = !flag;
            res.add(level);

        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
