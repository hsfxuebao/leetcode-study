package leetcode.editor.cn;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1817, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 回文链表
 *
 * @author hsfxuebao
 * 2023-11-13 17:36:55 
 */
class P234_PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new P234_PalindromeLinkedList().new Solution();
        
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
    public boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        // 找到中间节点，奇数为中间，偶数 为 靠右的节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 奇数情况
        if (fast != null) {
            slow = slow.next;
        }

        // 反转slow 到 最后的链表
        ListNode preNode = reverseIcur(slow);
        ListNode p1 = head, p2 = preNode;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;

    }

    // 反转链表，返回头结点
    private ListNode reverseIcur(ListNode head) {

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
