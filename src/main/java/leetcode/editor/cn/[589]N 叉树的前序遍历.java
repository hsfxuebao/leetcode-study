package leetcode.editor.cn;

//给定一个 n 叉树的根节点 
// root ，返回 其节点值的 前序遍历 。 
//
// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数在范围
// [0, 10⁴]内 
// 0 <= Node.val <= 10⁴ 
// n 叉树的高度小于或等于 1000 
// 
//
// 
//
// 进阶：递归法很简单，你可以使用迭代法完成此题吗? 
//
// Related Topics栈 | 树 | 深度优先搜索 
//
// 👍 336, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的前序遍历
 *
 * @author hsfxuebao
 * 2023-02-06 20:49:36 
 */
class P589_NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P589_NAryTreePreorderTraversal().new Solution();
        
    }
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }

    private void traverse(Node root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        res.add(root.val);
        for (Node child : root.children) {
            traverse(child);
        }
        // 后序遍历位置

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
