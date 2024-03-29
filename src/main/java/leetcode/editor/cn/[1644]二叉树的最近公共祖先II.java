package leetcode.editor.cn;



import common.TreeNode;

/**
 * @author hsfxuebao
 * Created on 2023-01-02
 * 给定一棵二叉树的根节点 root，返回给定节点 p 和 q 的最近公共祖先（LCA）节点。
 * 如果 p 或 q 之一不存在于该二叉树中，返回 null。
 * 树中的每个节点值都是互不相同的。
 *
 * 根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是后代节点中既包括 p 又包括 q 的最深节点（我们允许一个节点为自身的一个后代节点）”。
 * 一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
 * ————————————————
 * https://blog.csdn.net/qq_21201267/article/details/119707604
 */
class P1644_lowestCommonAncestor {

    public static void main(String[] args) {

    }

    class Solution {

        boolean findQ = false;
        boolean findP = false;
        TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            TreeNode treeNode = find(root, p.val, q.val);
            if (findP && findQ) {
                return treeNode;
            }
            return null;
        }

        private TreeNode find(TreeNode root, int p, int q) {
            if (root == null) {
                return null;
            }

            TreeNode left = find(root.left, p, q);
            TreeNode right = find(root.right, p, q);
            if (root.val == p || root.val == q) {
                if (root.val == p) {
                    findP = true;
                }
                if (root.val == q) {
                    findQ = true;
                }
                return root;
            }
            if (left != null && right != null) {
                return root;
            }
            return left == null ? right : left;

        }


    }



}
