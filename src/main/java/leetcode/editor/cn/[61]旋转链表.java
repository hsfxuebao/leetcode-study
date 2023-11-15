package leetcode.editor.cn;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1010, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 旋转链表
 *
 * @author hsfxuebao
 * 2023-11-14 09:17:14 
 */
class P61_RotateList{
    public static void main(String[] args) {
        Solution solution = new P61_RotateList().new Solution();
        
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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        // 统计链表的长度
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        // 需要移动的位置
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到倒数第k+1个位置
        ListNode preNode = findK(dummy, k+1);

        ListNode rotateNode = preNode.next;
        preNode.next = null;
        ListNode q = rotateNode;
        while (q.next != null) {
            q = q.next;
        }
        q.next = head;
        return rotateNode;
    }

    private ListNode findK(ListNode head, int k) {

        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
