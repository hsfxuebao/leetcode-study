package leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 607, 👎 0 
//
//
//
//

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


import common.TreeNode;

/**
 * 二叉树最大宽度
 * https://blog.csdn.net/qq_26470817/article/details/126557279
 * @author hsfxuebao
 * 2023-11-21 20:55:15 
 */
class P662_MaximumWidthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P662_MaximumWidthOfBinaryTree().new Solution();
        
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


    // 重建一个新节点，bfs+节点编号
    public int widthOfBinaryTree(TreeNode root) {

//        return bfs(root);

        dfs(root, 1, 0);
        return result;
    }
    int result = 0;
    Map<Integer, Integer> levelMinValMap = new HashMap<>();
    private void dfs(TreeNode root, int nodeIndex, int level) {
        if (root == null) {
            return;
        }
        // 放入当前level最小值
        levelMinValMap.putIfAbsent(level, nodeIndex);
        result = Math.max(result, nodeIndex - levelMinValMap.get(level)+1);
        dfs(root.left, nodeIndex*2, level+1);
        dfs(root.right, nodeIndex*2+1, level+1);

    }

    private int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(1, root.left, root.right));
        int res = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int startIndex = -1, endIndex = -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (startIndex == -1) {
                    startIndex = node.val;
                }
                endIndex = node.val;
                if (node.left != null) {
                    queue.offer(new TreeNode(node.val * 2, node.left.left, node.left.right));
                }
                if (node.right != null) {
                    queue.offer(new TreeNode(node.val * 2+1, node.right.left, node.right.right));
                }
            }
            res = Math.max(res, endIndex - startIndex +1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
