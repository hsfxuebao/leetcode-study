package leetcode.editor.cn;
import common.ListNode;
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
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
// Related Topics 链表 
// 👍 1452 👎 0

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

    // todo 后驱节点
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 递归方式实现
        return reverseBetweenRecursion(head, left, right);
    }

    /**
     * 递归实现，反转从left到right
     */
    private ListNode reverseBetweenRecursion(ListNode head, int left, int right) {

        if (left == 1) {
            // 反转前right个节点
            return reverseNRecursion(head, right);
        }
        // 递归
        head.next = reverseBetweenRecursion(head.next, left -1, right - 1);
        return head;
    }

    /**
     * 递归实现  反转前n个节点的链表
     * 反转以head为起点的前n个节点，返回新的头节点
     */
    private ListNode reverseNRecursion(ListNode head, int n) {

        if (n == 1) {
            // 记录后驱节点，当前节点的下一个节点
            successor = head.next;
            return head;
        }
        // 递归 以head.next为起点，反转前n-1个节点
        ListNode last = reverseNRecursion(head.next, n-1);
        //
        head.next.next = head;
        // 将反转之后的head节点和后面的节点连接起来
        head.next = successor;
        return last;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
