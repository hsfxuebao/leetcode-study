package leetcode.editor.cn;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1684, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 反转链表 II
 *
 * @author hsfxuebao
 * 2023-11-13 10:16:21 
 */
class P92_ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
        
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 递归
//        return reverseBetweenRec(head, left, right);
        // 迭代
        return reverseBetweenIter(head, left, right);
    }

    private ListNode reverseBetweenIter(ListNode head, int left, int right) {

        ListNode leftNode = null, rightNode = null,leftPre = null, rightPre = null;
        int nodeNum = 1;
        ListNode cur = head;
        while (cur != null && nodeNum <= right+1) {
            if (nodeNum == left - 1) {
                leftPre = cur;
            }
            if (nodeNum == left) {
                leftNode = cur;
            }
            if (nodeNum == right+1) {
                rightNode = cur;
            }
            cur = cur.next;
            nodeNum++;
        }

        // 迭代反转链表 左闭右开
        ListNode newHead = reverseIter(leftNode, rightNode);
        leftNode.next = rightNode;
        if (leftPre != null) {
            leftPre.next = newHead;
            return head;
        }
        return newHead;
    }

    // 迭代反转a到b，返回头结点,注意 左闭右开[a,b)
    private ListNode reverseIter(ListNode a, ListNode b) {

        ListNode pre = null, next = null, cur = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode reverseBetweenRec(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseRec(head, right);
        }
        head.next = reverseBetweenRec(head.next, left-1, right-1);
        return head;
    }

    // 反转链表的前n个节点，返回新的头节点
    ListNode successor = null;
    private ListNode reverseRec(ListNode head, int n) {

        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，反转前n-1节点
        ListNode last = reverseRec(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
