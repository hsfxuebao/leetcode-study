package leetcode.editor.cn;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1205, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author hsfxuebao
 * 2023-11-14 09:00:59 
 */
class P82_RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();
        
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;
        while (q != null) {

            // 有重复的元素
            if (q.next != null && q.val == q.next.val) {
                // 跳过重复的元素
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;
            } else {
                // 无重复的元素
                ListNode next = q.next;
                // 断开链接
                q.next = null;
                p.next = q;
                p = p.next;
                q = next;
            }

        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
