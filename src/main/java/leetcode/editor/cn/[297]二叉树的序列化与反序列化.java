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
// 👍 1182, 👎 0 
//
//
//
//

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;


import common.TreeNode;

/**
 * 二叉树的序列化与反序列化
 *
 * @author hsfxuebao
 * 2023-11-22 11:14:52 
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

    String NULL = "#";
    String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 先序遍历
//        return serializePre(root);
        // 后续遍历
//        return serializePost(root);
        // 层序遍历
        return serializeLevel(root);
    }

    private String serializeLevel(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(node.val).append(SEP);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();

    }

    //
    private String serializePost(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePost(root, sb);
        return sb.toString();
    }

    private void serializePost(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        serializePost(root.left, sb);
        serializePost(root.right, sb);
        // 后序
        sb.append(root.val).append(SEP);
    }


    private String serializePre(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePre(root, sb);
        return sb.toString();
    }
    private void serializePre(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 先序
        sb.append(root.val).append(SEP);
        serializePre(root.left, sb);
        serializePre(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // 先序
//        return deserializePre(data);
        // 后序
//        return deserializePost(data);
        // 层序
        return deserializeLevel(data);
    }

    private TreeNode deserializeLevel(String data) {
        if (data.isEmpty()) {
            return null;
        }
        LinkedList<String> levelList = new LinkedList<>();
        String[] split = data.split(SEP);
        for (String s : split) {
            levelList.add(s);
        }
        return deserializeLevel(levelList);

    }
    private TreeNode deserializeLevel(LinkedList<String> levelList) {

        String str = levelList.removeFirst();
        if (NULL.equals(str)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str));
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 左边
                String leftStr = levelList.removeFirst();
                if (!NULL.equals(leftStr)) {
                    node.left = new TreeNode(Integer.parseInt(leftStr));
                    queue.offer(node.left);
                } else {
                    node.left = null;
                }

                // 右边
                String rightStr = levelList.removeFirst();
                if (!NULL.equals(rightStr)) {
                    node.right = new TreeNode(Integer.parseInt(rightStr));
                    queue.offer(node.right);
                } else {
                    node.right = null;
                }

            }
        }
        return root;
    }

    private TreeNode deserializePost(String data) {
        LinkedList<String> postList = new LinkedList<>();
        String[] split = data.split(SEP);
        for (String s : split) {
            postList.add(s);
        }
        return deserializePost(postList);

    }

    private TreeNode deserializePost(LinkedList<String> postList) {

        String str = postList.removeLast();
        if (NULL.equals(str)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.right = deserializePost(postList);
        node.left = deserializePost(postList);
        return node;
    }

    private TreeNode deserializePre(String data) {
        LinkedList<String> preList = new LinkedList<>();
        String[] split = data.split(SEP);
        for (String s : split) {
            preList.add(s);
        }
        return deserializePre(preList);
    }

    private TreeNode deserializePre(LinkedList<String> preList) {

        String str = preList.removeFirst();
        if (NULL.equals(str)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = deserializePre(preList);
        node.right = deserializePre(preList);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
 
}
