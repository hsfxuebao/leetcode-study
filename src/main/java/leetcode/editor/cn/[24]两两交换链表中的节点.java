package leetcode.editor.cn;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics递归 | 链表 
//
// 👍 2084, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author hsfxuebao
 * 2023-11-14 09:11:19 
 */
class P24_SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new P24_SwapNodesInPairs().new Solution();
        
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

    public ListNode swapPairs(ListNode head) {

        return reverseKGroup(head, 2);
    }

    // k个一组反转链表
    private ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 不够k个
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        // 反转链表[a,b)
        ListNode newHead = reverseIter(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverseIter(ListNode a, ListNode b) {

        ListNode pre = null, cur = a, next = a;
        while (cur != b) {

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
