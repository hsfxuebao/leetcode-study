package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

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
class Codec {

    // 分隔符
    String SEP = ",";
    // null
    String NULL = "#";
    // 用于拼接字符串
    StringBuilder sb = new StringBuilder();

    /**
     * 前序遍历
     */
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        traverse(root, sb);
//        return sb.toString();
//    }
//    private void traverse(TreeNode root, StringBuilder sb) {
//
//        if (root == null) {
//            sb.append(NULL).append(SEP);
//            return;
//        }
//        // 先序位置
//        sb.append(root.val).append(SEP);
//
//        traverse(root.left, sb);
//        traverse(root.right, sb);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        LinkedList<String> nodes = new LinkedList<String>();
//        for (String node : data.split(SEP)) {
//            nodes.add(node);
//        }
//        return deserialize(nodes);
//    }
//
//    private TreeNode deserialize(LinkedList<String> nodes) {
//        if (nodes.isEmpty()) {
//            return null;
//        }
//
//        String first = nodes.removeFirst();
//        if (NULL.equals(first)) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(first));
//        root.left = deserialize(nodes);
//        root.right = deserialize(nodes);
//        return root;
//    }


    /**
     * 后序遍历
     */
//    public String serialize(TreeNode root) {
//        traverse(root, sb);
//        return sb.toString();
//    }
//    private void traverse(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            sb.append(NULL).append(SEP);
//            return;
//        }
//
//        traverse(root.left, sb);
//        traverse(root.right, sb);
//
//        // 后续位置
//        sb.append(root.val).append(SEP);
//    }
//
//    public TreeNode deserialize(String data) {
//       LinkedList<String> nodes = new LinkedList<>();
//        for (String node : data.split(SEP)) {
//            nodes.add(node);
//        }
//        return deserialize(nodes);
//    }
//    private TreeNode deserialize(LinkedList<String> nodes) {
//
//        if (nodes.isEmpty()) {
//            return null;
//        }
//        String last = nodes.removeLast();
//        if (NULL.equals(last)) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(last));
//        // todo 先构造 右子树，再构造左子树
//        root.right = deserialize(nodes);
//        root.left = deserialize(nodes);
//        return root;
//    }

    /**
     * 中序遍历
     * 由于中序遍历 不能首先找到根节点，所以没有办法反序列化
     */
//    public String serialize(TreeNode root) {
//        traverse(root, sb);
//        return sb.toString();
//    }
//    private void traverse(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            sb.append(NULL).append(SEP);
//            return;
//        }
//        traverse(root.left, sb);
//        sb.append(root.val).append(SEP);
//        traverse(root.right, sb);
//    }


    /**
     * 层序遍历
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return sb.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }

            sb.append(cur.val).append(SEP);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEP);
        return deserialize(nodes);
    }

    private TreeNode deserialize(String[] nodes) {
        if (nodes == null || nodes.length <= 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for (int i = 1; i < nodes.length; ) {
            TreeNode parent = queue.poll();

            // 左节点
            String leftVal = nodes[i++];
            if (NULL.equals(leftVal)) {
                parent.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(leftVal));
                parent.left = leftNode;
                queue.add(leftNode);
            }

            // 右节点
            String rightVal = nodes[i++];
            if (NULL.equals(rightVal)) {
                parent.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(rightVal));
                parent.right = rightNode;
                queue.add(rightNode);
            }
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
