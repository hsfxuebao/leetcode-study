package leetcode.editor.cn;

import common.TreeNode;

/**
 * @author hsfxuebo
 * Created on 2023-03-15
 *
 * https://blog.csdn.net/YuanTheCoder/article/details/99945418
 */
class P250_countUnivalSubtrees {


    public static void main(String[] args) {

    }


    class Solution {

        int res = 0;
        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) {
                return res;
            }
            getUnival(root);
            return res;
        }

        /**
         * 定义一颗二叉树，如果这颗二叉树的所有节点值 都相同，则返回它们的值
         * 如果这颗二叉树的所有节点的值不是相同的，则返回-2000
         */
        private int getUnival(TreeNode root) {
            // 先计算出 左右子树的值 如果为null可以设置成root.val的值
            int leftVal = root.left == null ? root.val : getUnival(root.left);
            int rightVal = root.right == null ? root.val : getUnival(root.right);
            // 左子树 或右子树 不是同值子树
            if (leftVal == -2000 || rightVal == -2000) {
                return -2000;
            }
            if (leftVal == rightVal && leftVal == root.val) {
                res++;
                return root.val;
            }
            // 否则，以 root 为根的⼆叉树不是⼀棵所有节点都相同的⼆叉树
            return -2000;
        }
    }



}
