package leetcode.editor.cn;

/**
 * @author hsfxuebao
 * Created on 2023-01-02
 * 给定一棵二叉树中的两个节点 p 和 q，返回它们的最近公共祖先节点（LCA）。
 *
 * 每个节点都包含其父节点的引用（指针）。Node 的定义如下：
 *
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node parent;
 * }
 * 根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是后代节点中既包括 p 又包括 q 的最深节点（我们允许一个节点为自身的一个后代节点）”。
 *
 * 一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
 * ————————————————
 * https://blog.csdn.net/qq_21201267/article/details/119707750
 */
class P1650_lowestCommonAncestor {
    public static void main(String[] args) {

    }


    class Solution {

        // 根本问题 求 两个单链表的相交问题
        Node lowestCommonAncestor(Node p, Node q) {
            Node a = p, b = q;

            while (a != b) {
                if (a == null) {
                    a = q;
                } else {
                    a = a.parent;
                }
                if (b == null) {
                    b = p;
                } else {
                    b = b.parent;
                }
            }
            return a;
        }

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }



}
