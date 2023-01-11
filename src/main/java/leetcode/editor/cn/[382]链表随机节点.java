package leetcode.editor.cn;

//给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。 
//
// 实现 Solution 类： 
//
// 
// Solution(ListNode head) 使用整数数组初始化对象。 
// int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
//[[[1, 2, 3]], [], [], [], [], []]
//输出
//[null, 1, 3, 2, 2, 3]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.getRandom(); // 返回 1
//solution.getRandom(); // 返回 3
//solution.getRandom(); // 返回 2
//solution.getRandom(); // 返回 2
//solution.getRandom(); // 返回 3
//// getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。 
//
// 
//
// 提示： 
//
// 
// 链表中的节点数在范围 [1, 104] 内 
// -104 <= Node.val <= 104 
// 至多调用 getRandom 方法 104 次 
// 
//
// 
//
// 进阶： 
//
// 
// 如果链表非常大且长度未知，该怎么处理？ 
// 你能否在不使用额外空间的情况下解决此问题？ 
// 
// Related Topics 水塘抽样 链表 数学 随机化 
// 👍 323 👎 0

import java.util.Random;

import common.ListNode;

/**
 * 链表随机节点
 *
 * @author hsfxuebao
 * 2023-01-11 21:42:52 
 */
class P382_LinkedListRandomNode{
    public static void main(String[] args) {
//        Solution solution = new P382_LinkedListRandomNode().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    /**
     * 水塘抽样算法
     * @return
     */
    /* 返回链表中一个随机节点的值 */
    public int getRandom() {

        ListNode p = head;
        int res = 0;
        int i = 0;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            int random = new Random().nextInt(i);
            if (0 == random) {
                res = p.val;
            }
            p = p.next;
        }
        return res;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
