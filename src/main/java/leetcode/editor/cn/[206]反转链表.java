package leetcode.editor.cn;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
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
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics递归 | 链表 
//
// 👍 3429, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 反转链表
 *
 * @author hsfxuebao
 * 2023-12-04 20:11:54 
 */
class P206_ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();
        
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
    public ListNode reverseList(ListNode head) {

        // 递归
//        return reverseListRec(head);
        // 迭代
        return reverseListIte(head);

    }

    private ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

    private ListNode reverseListIte(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, next = head, pre = null;
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
