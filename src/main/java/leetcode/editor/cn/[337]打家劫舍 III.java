package leetcode.editor.cn;

//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树 
//
// 👍 1875, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


import common.TreeNode;

/**
 * 打家劫舍 III
 *
 * @author hsfxuebao
 * 2023-09-28 09:58:42 
 */
class P337_HouseRobberIii{
    public static void main(String[] args) {
        Solution solution = new P337_HouseRobberIii().new Solution();
        
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
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 递归 + 备忘录
     */
    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        // 抢
        int do_it = root.val
                + (root.left != null ? rob1(root.left.left) + rob1(root.left.right) : 0)
                + (root.right != null ? rob1(root.right.left) + rob1(root.right.right) : 0);
        // 不抢
        int do_not_it = rob1(root.left) + rob1(root.right);
        int res = Math.max(do_it, do_not_it);
        map.put(root, res);
        return res;
    }

    int rob2(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
    arr[0] 表示不抢 root 的话，得到的最大钱数
    arr[1] 表示抢 root 的话，得到的最大钱数 */
    int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);
//        int not_rob = left[1] + right[1];

        return new int[]{not_rob, rob};
    }


    // todo 层序遍历是不可以的
    int rob(TreeNode root) {
        // 层序遍历
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelSumList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelSumList.add(sum);
        }

        int[] nums = new int[levelSumList.size()];
        for (int i = 0; i < levelSumList.size(); i++) {
            nums[i] = levelSumList.get(i);
        }
        return rob(nums);


    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+2];
        // base case

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-2]);
        }
        return dp[nums.length+1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
