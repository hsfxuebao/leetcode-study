package leetcode.editor.cn;

//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1421, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 重排链表
 *
 * @author hsfxuebao
 * 2023-12-22 17:14:28 
 */
class P143_ReorderList{
    public static void main(String[] args) {
        Solution solution = new P143_ReorderList().new Solution();
        
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

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        // 找到中间节点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //
        ListNode rightHead = slow.next;
        slow.next = null;

        // 反转链表
        ListNode rightNode = reverse1(rightHead);

        // 合并成一个链表
        ListNode p1 = head, p2 = rightNode;
        while (p2 != null) {
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;

            p1.next = p2;
            p2.next = p1Next;

            p1 = p1Next;
            p2 = p2Next;
        }


    }

    private ListNode reverse1(ListNode head) {

        ListNode pre = null, next = head, cur = head;
        while (cur != null) {
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
