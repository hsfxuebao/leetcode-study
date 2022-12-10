package leetcode.editor.cn;
import common.ListNode;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 2330 👎 0


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
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 先找到 倒数第n个节点的前一个节点，也就是倒数第n+1个节点
        ListNode p = findNthFromEnd(dummy, n + 1);
        // 删除倒数第n个节点
        p.next = p.next.next;
        return dummy.next;
    }

    // 获取倒数第m个节点
    public ListNode findNthFromEnd(ListNode head, int m) {
        // p1指针
        ListNode p1 = head, p2 = head;

        // p1指针先走m
        for (int i = 0; i < m; i++) {
            p1 = p1.next;
        }

        // p1,p2指针同时走n-k步，直到p1指针为null
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
