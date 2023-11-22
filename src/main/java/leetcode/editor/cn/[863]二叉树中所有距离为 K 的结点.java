package leetcode.editor.cn;

//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。 
//
// 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//输出：[7,4,1]
//解释：所求结点为与目标结点（值为 5）距离为 2 的结点，值分别为 7，4，以及 1
// 
//
// 示例 2: 
//
// 
//输入: root = [1], target = 1, k = 3
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 500] 范围内 
// 0 <= Node.val <= 500 
// Node.val 中所有值 不同 
// 目标结点 target 是树上的结点。 
// 0 <= k <= 1000 
// 
//
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 660, 👎 0 
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
 * 二叉树中所有距离为 K 的结点
 *
 * @author hsfxuebao
 * 2023-11-22 09:49:28 
 */
class P863_AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P863_AllNodesDistanceKInBinaryTree().new Solution();
        
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

    // 记录节点的父节点
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 遍历，记录每个节点的父节点
        recordParentNode(root);

        //
        findTargetK(target, null, 0, k);
        return res;
    }

    /**
     *
     * @param from 从那个节点进来的，不走回头路
     * @param distance 距离target节点的距离
     * @param k
     */
    private void findTargetK(TreeNode root, TreeNode from, int distance, int k) {
        if (root == null) {
            return;
        }
        if (distance == k) {
            res.add(root.val);
            return;
        }

        // 选择集 左子树 右子树  父节点  分别遍历，
        // todo 不走回头路
        if (root.left != from) {
            findTargetK(root.left, root, distance+1, k);
        }
        if (root.right != from) {
            findTargetK(root.right, root, distance+1, k);
        }
        if (parentMap.get(root.val) != from) {
            findTargetK(parentMap.get(root.val), root, distance+1, k);
        }

    }

    private void recordParentNode(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            recordParentNode(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            recordParentNode(root.right);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
