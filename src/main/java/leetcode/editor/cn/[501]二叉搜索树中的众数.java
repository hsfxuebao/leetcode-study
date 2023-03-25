package leetcode.editor.cn;

//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 609, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.TreeNode;

/**
 * 二叉搜索树中的众数
 *
 * @author hsfxuebao
 * 2023-03-19 15:09:50 
 */
class P501_FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P501_FindModeInBinarySearchTree().new Solution();
        
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

    List<Integer> mode = new ArrayList<>();
    // 当前元素的重复次数
    int curCount = 0;
    // 全局最长相同序列长度
    int maxCount = 0;
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        traverse(root);

        int[] res = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++) {
            res[i] = mode.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历
        if (pre == null) {
            curCount = 1;
            maxCount = 1;
            mode.add(root.val);
        } else {

            if (root.val == pre.val) {
                curCount++;
                if (curCount == maxCount) {
                    mode.add(root.val);
                }
                if (curCount > maxCount) {
                    mode.clear();
                    maxCount = curCount;
                    mode.add(root.val);
                }
            }

            if (root.val != pre.val) {
                curCount = 1;
                if (curCount == maxCount) {
                    mode.add(root.val);
                }
            }
        }
        pre = root;
        traverse(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
