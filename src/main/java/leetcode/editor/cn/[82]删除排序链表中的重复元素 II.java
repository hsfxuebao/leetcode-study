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
// 👍 1183, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author hsfxuebao
 * 2023-09-19 11:01:44 
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

        ListNode dummy = new ListNode(-1);
        ListNode p1 = dummy, p2 = head;
        while (p2 != null) {
            if (p2.next != null && p2.val == p2.next.val) {

                // 发现重复节点，跳过重复节点
                while (p2.next != null && p2.val == p2.next.val) {
                    p2 = p2.next;
                }
                // 此时 p2 跳过了当前节点的重复节点
                p2 = p2.next;
                // 不过下一节点也可能重复，等下一轮while循环判断

            } else {
                // 当前节点和下一个节点不相等
                ListNode p2Next = p2.next;
                p1.next = p2;
                p1 = p1.next;
                // 断开p2节点后面的所有节点
                p2.next = null;
                p2 = p2Next;
            }

        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
