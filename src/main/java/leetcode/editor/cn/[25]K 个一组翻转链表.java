package leetcode.editor.cn;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics递归 | 链表 
//
// 👍 2253, 👎 0 
//
//
//
//

import javax.swing.plaf.basic.BasicTableHeaderUI;

import common.ListNode;

/**
 * K 个一组翻转链表
 *
 * @author hsfxuebao
 * 2023-12-22 16:23:53 
 */
class P25_ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25_ReverseNodesInKGroup().new Solution();
        
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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode aHead = head, bHead = head;
        for (int i = 0; i < k; i++) {
            if (bHead == null) {
                return head;
            }
            bHead = bHead.next;
        }

        // 反转链表
        ListNode newHead = reverse(aHead, bHead);
        aHead.next = reverseKGroup(bHead, k);
        return newHead;

    }

    // [a, b)
    private ListNode reverse(ListNode aHead, ListNode bHead) {

        ListNode cur = aHead, next = aHead, pre = null;
        while (cur != bHead) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
