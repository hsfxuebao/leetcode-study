package leetcode.editor.cn;

//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics链表 
//
// 👍 1067, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 删除排序链表中的重复元素
 *
 * @author hsfxuebao
 * 2023-11-13 21:26:01 
 */
class P83_RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
        
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
        // 快慢指针
        ListNode fast = head, slow = head;
        while (fast != null) {

            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开 链接
        slow.next = null;
        return head;

//        ListNode dummy = new ListNode(-1);
//        ListNode p = dummy, pre = head, cur = head.next;
//        p.next = new ListNode(head.val);
//        p = p.next;
//        while (cur != null) {
//            ListNode next = cur.next;
//            if (cur.val != pre.val) {
//                p.next = new ListNode(cur.val);
//                p = p.next;
//                pre = cur;
//            }
//            cur = next;
//        }
//        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
