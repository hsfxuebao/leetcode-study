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
// 👍 2507, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import common.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author hsfxuebao
 * 2023-04-16 09:26:49 
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

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到倒数 第n+1的节点
        ListNode fromEnd = findFromEnd(dummy, n + 1);
        fromEnd.next = fromEnd.next.next;
        return dummy.next;

    }

    // 找到 倒数第k个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;

        // p1节点先走K步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // p1和p2节点同时走，p1节点为null
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
 
}
