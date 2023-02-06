package leetcode.editor.cn;

//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树的深度不会超过 1000 。 
// 树的节点数目位于 [0, 10⁴] 之间。 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 
//
// 👍 324, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.Node;

import java.util.List;

/**
 * N 叉树的最大深度
 *
 * @author hsfxuebao
 * 2023-02-06 19:30:14 
 */
class P559_MaximumDepthOfNAryTree{
    public static void main(String[] args) {
        Solution solution = new P559_MaximumDepthOfNAryTree().new Solution();
        
    }

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
    }
    //leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.



class Solution {

    /**
     * 分解子问题
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int subTreeDepth = 0;
        for (Node child : root.children) {
            subTreeDepth = Math.max(subTreeDepth, maxDepth(child));
        }
        return 1 + subTreeDepth;
    }

    /**
     * 遍历
     */
    private int depth = 0;
    private int res = 0;
    public int maxDepth1(Node root) {
        traverse(root);
        return res;
    }

    private void traverse(Node root) {

        if (root == null) {
            return;
        }
        // 前序遍历位置
        depth++;
        res = Math.max(res, depth);
        for (Node child : root.children) {
            traverse(child);
        }
        // 后续遍历位置
        depth--;

    }
}

//leetcode submit region end(Prohibit modification and deletion)
 
}
