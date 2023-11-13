package leetcode.editor.cn;

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
//
// Related Topics链表 | 双指针 
//
// 👍 2727, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author hsfxuebao
 * 2023-11-13 14:27:32 
 */
class P19_RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
        
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 防止出现空指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到要删除节点的前一个节点
        ListNode preNode = findN(dummy, n + 1);
        preNode.next = preNode.next.next;
        return dummy.next;
    }

    // 查找倒数第n个节点，并返回
    private ListNode findN(ListNode head, int n) {

        ListNode fast = head, slow = head;
        // 快指针先走n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 快慢指针同时走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
