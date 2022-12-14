package leetcode.editor.cn;
import common.Node;
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution116 {


    /**
     * 层序遍历
     * 空间复杂度 O(n) 不符合要求
     */
    public Node connect1(Node root) {

        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                // next节点
                if (i < levelSize - 1) {
                    node.next = queue.peek();
                }

                // 把下层 添加到队列中
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }

            }
        }
        // 返回根节点
        return root;
    }


    /**
     * 遍历
     */
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    private void traverse(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return;
        }
        /**
         * 前序位置
         */
        // 连接next节点
        node1.next = node2;

        // 连接 相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接 跨越 父节点的两个子节点
        traverse(node1.right, node2.left);


    }

}
//leetcode submit region end(Prohibit modification and deletion)
