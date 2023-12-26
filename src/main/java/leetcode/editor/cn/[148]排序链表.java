package leetcode.editor.cn;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics链表 | 双指针 | 分治 | 排序 | 归并排序 
//
// 👍 2191, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 排序链表
 *
 * @author hsfxuebao
 * 2023-12-20 16:47:19 
 */
class P148_SortList{
    public static void main(String[] args) {
        Solution solution = new P148_SortList().new Solution();
        
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


    // 归并排序
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 找到链表中的中间节点，奇数中间，偶数中间偏左
       ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        // 断开节点
        slow.next = null;

        // 分别排序
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(temp);
        ListNode node  = merge(list1, list2);
        return node;
    }

    private ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {

            if (p1.val > p2.val) {
                p.next = new ListNode(p2.val);
                p = p.next;
                p2 = p2.next;
            } else {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
            }
        }

        // 判空
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
