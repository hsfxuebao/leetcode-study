package leetcode.editor.cn;
import javax.lang.model.element.NestingKind;

import common.ListNode;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
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
// 
// Related Topics 递归 链表 
// 👍 2872 👎 0


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

        // 迭代方式实现
        // return reverseIteration(head);

        // 递归方式实现
         return reverseRecursion(head);


    }

    /**
     * 递归方式实现
     */
    private ListNode reverseRecursion(ListNode head) {

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // 递归
        ListNode last = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 迭代方式实现
     */
    private ListNode reverseIteration(ListNode head) {

        ListNode pre = null, current = head, next = head;

        while (current != null) {

            // 下一个节点的位置
            next = current.next;
            // 当前节点的下一个节点
            current.next = pre;
            // 更新 pre节点
            pre = current;

            current = next;
        }
        return pre;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
