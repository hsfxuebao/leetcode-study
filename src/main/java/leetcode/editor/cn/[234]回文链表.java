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
// 👍 1667, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.ListNode;

/**
 * 回文链表
 *
 * @author hsfxuebao
 * 2023-04-16 11:03:12 
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


    // 找到链表中间的节点，反转 中间节点之后的节点
    public boolean isPalindrome(ListNode head) {

        // 快慢指针 找到中间节点，奇数中间，偶数偏右节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            // 奇数
            slow = slow.next;
        }
        // 反转slow链表
        ListNode reverse = reverse(slow);
        ListNode p2 = reverse, p1 = head;
        while (p2 != null) {
            if (p2.val != p1.val) {
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;

    }

    // 反转链表
    private ListNode reverse(ListNode slow) {

       ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
