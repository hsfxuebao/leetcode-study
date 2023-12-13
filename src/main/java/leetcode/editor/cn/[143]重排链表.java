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
// 👍 1415, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.ListNode;

/**
 * 重排链表
 *
 * @author hsfxuebao
 * 2023-12-11 09:29:46 
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


        // 快慢指针  找到中间位置
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // 断开节点
        ListNode postNode = slow.next;
        slow.next = null;

        // 反转链表
        ListNode newHead = reverseIter(postNode);


        ListNode p1 = head, p2 = newHead;
        // 较差链接链表
        while (p1 != null) {

            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;

            p1.next = p2;
            p1 = p1Next;

            p2.next = p1;
            p2 = p2Next;

        }

    }

    private ListNode reverseIter(ListNode head) {

        ListNode pre = null, cur = head, next = head;
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
