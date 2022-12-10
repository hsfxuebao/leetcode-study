package leetcode.editor.cn;
import javax.annotation.Resource;

import common.ListNode;
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
// 链表中节点数目在范围[1, 105] 内
// 0 <= Node.val <= 9
//
//
//
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针
// 👍 1576 👎 0


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
class Solution234 {

    public boolean isPalindrome(ListNode head) {
        // 使用 链表 后续遍历实现
//        return isPalindromeV1(head);
        // 使用 部分反转链表实现
        return isPalindromeV2(head);

    }

    /**
     * 使用 反转 右半部分链表实现
     */
    private boolean isPalindromeV2(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 表示 奇数
        if (fast != null) {
            slow = slow.next;
        }
        // slow 反转链表
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // 反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 使用链表后续遍历 实现回文链表的判断
     */
    ListNode left;
    private boolean isPalindromeV1(ListNode head) {
        left = head;
        return traverse(head);

    }

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean result = traverse(right.next);
        // 后续遍历代码
        result = result && (left.val == right.val);
        left = left.next;
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
