package leetcode.editor.cn;

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树 
//
// 👍 1076, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.LinkedList;
import java.util.Queue;


import com.sun.deploy.util.StringUtils;

import common.TreeNode;

/**
 * 二叉树的序列化与反序列化
 *
 * @author hsfxuebao
 * 2023-03-23 21:17:20 
 */
class P297_SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {

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
public class Codec {

    // Encodes a tree to a single string.
    String NULL = "#";
    String SEP = ",";
    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root) {
        // 前序
//        traverse(root, sb);
        // 后序
//        traversePost(root, sb);
        // 层序
        traverseLevel(root, sb);
        return sb.toString();
    }

    private void traverseLevel(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val).append(SEP);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node.left != null) {
                sb.append(node.left.val).append(SEP);
                queue.offer(node.left);
            } else {
                sb.append(NULL).append(SEP);
            }

            if (node.right != null) {
                sb.append(node.right.val).append(SEP);
                queue.offer(node.right);
            } else {
                sb.append(NULL).append(SEP);
            }
        }

    }

    private void traversePost(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        traversePost(root.left, sb);
        traversePost(root.right, sb);
        // 后序
        sb.append(root.val).append(SEP);
    }

    private void traverse(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 前序位置
        sb.append(root.val).append(SEP);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    LinkedList<String> nodes = new LinkedList<String>();
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        for (String str : data.split(SEP)) {
            nodes.add(str);
        }
        // 前序
//        return deserialize(nodes);
        // 后序
//        return deserializePost(nodes);
        // 层序
        return deserializeLevel(nodes);
    }

    private TreeNode deserializeLevel(LinkedList<String> nodes) {

        if (nodes.isEmpty()) {
            return null;
        }
        String nodeVal = nodes.get(0);
        TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        for (int i = 1; i < nodes.size(); ) {
            TreeNode root = queue.poll();
            String leftVal = nodes.get(i++);
            if (NULL.equals(leftVal)) {
                root.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(leftVal));
                root.left = leftNode;
                queue.offer(leftNode);
            }
            String rightVal = nodes.get(i++);
            if (NULL.equals(rightVal)) {
                root.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(rightVal));
                root.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return node;
    }

    private TreeNode deserializePost(LinkedList<String> nodes) {

        if (nodes.isEmpty()) {
            return null;
        }
        String nodeVal = nodes.removeLast();
        if (NULL.equals(nodeVal)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
        node.right = deserializePost(nodes);
        node.left = deserializePost(nodes);
        return node;
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 找到根节点
        String rootVal = nodes.removeFirst();
        if (NULL.equals(rootVal)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
 
}
