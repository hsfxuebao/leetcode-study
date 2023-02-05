package leetcode.editor.cn;

//完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。 
//
// 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。 
//
// 实现 CBTInserter 类: 
//
// 
// CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构； 
// CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态
//，并返回插入节点 TreeNode 的父节点的值； 
// CBTInserter.get_root() 将返回树的头节点。 
// 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入
//["CBTInserter", "insert", "insert", "get_root"]
//[[[1, 2]], [3], [4], []]
//输出
//[null, 1, 2, [1, 2, 3, 4]]
//
//解释
//CBTInserter cBTInserter = new CBTInserter([1, 2]);
//cBTInserter.insert(3);  // 返回 1
//cBTInserter.insert(4);  // 返回 2
//cBTInserter.get_root(); // 返回 [1, 2, 3, 4] 
//
// 
//
// 提示： 
//
// 
// 树中节点数量范围为 [1, 1000] 
// 0 <= Node.val <= 5000 
// root 是完全二叉树 
// 0 <= val <= 5000 
// 每个测试用例最多调用 insert 和 get_root 操作 10⁴ 次 
// 
//
// Related Topics树 | 广度优先搜索 | 设计 | 二叉树 
//
// 👍 148, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树插入器
 *
 * @author hsfxuebao
 * 2023-02-05 10:20:50 
 */
class P919_CompleteBinaryTreeInserter{
    public static void main(String[] args) {
//        CBTInserter solution = new P919_CompleteBinaryTreeInserter().new CBTInserter();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {

    // 根节点
    private TreeNode root;
    // 记录那些元素可以 左右子节点都是null
    private Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {

        this.root = root;

        // 层序遍历
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);

        while (!temp.isEmpty()) {
            TreeNode curNode = temp.poll();
            if (curNode.left != null) {
                temp.offer(curNode.left);
            }
            if (curNode.right != null) {
                temp.offer(curNode.right);
            }

            // 如果左右子节点都是null
            if (curNode.left == null || curNode.right == null) {
                queue.offer(curNode);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode parentNode = queue.peek();
        if (parentNode.left == null) {
            parentNode.left = newNode;
        } else if (parentNode.right == null) {
            parentNode.right = newNode;
            // poll 这个节点左右子树 都是有值的，弹出队列
            queue.poll();
        }
        // 将newNode 节点 加入到 队列中
        queue.offer(newNode);
        return parentNode.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
