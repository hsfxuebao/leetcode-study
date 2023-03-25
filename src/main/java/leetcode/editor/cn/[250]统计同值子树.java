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
            // 先计算出 左右子树的值 是否全部相同
            int leftVal = root.left == null ? root.val : getUnival(root.left);
            int rightVal = root.right == null ? root.val : getUnival(root.right);

            // 如果有一颗子树的值不相同，那么以root为跟的这棵树的值肯定不可能全部相同
            if (leftVal == -2000 || rightVal == -2000) {
                return -2000;
            }

            // 如果左右子树的值相同 且等于root.val
            // 说明以root为跟的二叉树是一颗所有节点都相同的二叉树
            if (leftVal == rightVal && leftVal == root.val) {
                // 全局变量+1
                res++;
                return root.val;
            }
            // 否则，返回-2000 不是同值子树
            return -2000;

        }
    }



}
