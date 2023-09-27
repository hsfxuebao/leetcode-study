package leetcode.editor.cn;

//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 设计 | 二叉搜索树 | 字符串 | 二叉树 
//
// 👍 526, 👎 0 
//
//
//
//

import java.util.LinkedList;


import com.sun.deploy.util.StringUtils;

import common.TreeNode;

/**
 * 序列化和反序列化二叉搜索树
 *
 * @author hsfxuebao
 * 2023-09-25 21:22:50 
 */
class P449_SerializeAndDeserializeBst{
    public static void main(String[] args) {
//        Solution solution = new P449_SerializeAndDeserializeBst().new Solution();
        
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

    String SEP = ",";


    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();
    // 先序遍历
    public String serialize(TreeNode root) {
        if (root == null) {
            return sb.toString();
        }
        traceback(sb, root);
        return sb.toString();
    }

    private void traceback(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(SEP);
        traceback(sb, root.left);
        traceback(sb, root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<Integer> list = new LinkedList<>();
        if ("".equals(data)) {
            return null;
        }
        String[] split = data.split(SEP);
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        return deserialize(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(LinkedList<Integer> list, int minValue, int maxValue) {

        if (list.isEmpty()) {
            return null;
        }
        Integer nodeVal = list.getFirst();
        if (nodeVal > maxValue || nodeVal < minValue) {
            return null;
        }
        list.removeFirst();
        TreeNode root = new TreeNode(nodeVal);
        root.left = deserialize(list, minValue, nodeVal);
        root.right = deserialize(list, nodeVal, maxValue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)
 
}
