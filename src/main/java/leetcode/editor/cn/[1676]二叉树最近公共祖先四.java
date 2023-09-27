package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

import common.TreeNode;

/**
 * @author hsfxuebao
 * Created on 2023-01-02
 *
 * 给定一棵二叉树的根节点 root 和 TreeNode 类对象的数组（列表） nodes，返回 nodes 中所有节点的最近公共祖先（LCA）。
 * 数组（列表）中所有节点都存在于该二叉树中，且二叉树中所有节点的值都是互不相同的。
 *
 * 我们扩展二叉树的最近公共祖先节点在维基百科上的定义：“对于任意合理的 i 值， n 个节点 p1 、 p2、…、 pn 在二叉树 T 中的最近公共祖先节点是后代中包含所有节点 pi 的最深节点（我们允许一个节点是其自身的后代）”。
 *
 * 一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
 * 示例 1:
 * 在这里插入图片描述
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
 * 输出: 2
 * 解释: 节点 4 和 7 的最近公共祖先是 2。
 * https://blog.csdn.net/qq_21201267/article/details/119708076
 */
class P1676_lowestCommonAncestor {

    public static void main(String[] args) {

    }

    class Solution {


        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            // 将nodes转成set集合，便于判断
            Set<Integer> nodeSet = new HashSet<>();
            for (TreeNode node : nodes) {
                nodeSet.add(node.val);
            }
            return find(root, nodeSet);
        }

        private TreeNode find(TreeNode root, Set<Integer> nodeSet) {
            if (root == null) {
                return null;
            }
            if (nodeSet.contains(root.val)) {
                return root;
            }
            // 左右子树
            TreeNode left = find(root.left, nodeSet);
            TreeNode right = find(root.right, nodeSet);
            if (left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
        }

    }


}
