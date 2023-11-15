package leetcode.editor.cn;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 781, 👎 0 
//
//
//
//

import common.ListNode;

/**
 * 分隔链表
 *
 * @author hsfxuebao
 * 2023-11-14 09:05:19 
 */
class P86_PartitionList{
    public static void main(String[] args) {
        Solution solution = new P86_PartitionList().new Solution();
        
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
    public ListNode partition(ListNode head, int x) {

        ListNode smallNode = new ListNode(-1);
        ListNode bigNode = new ListNode(-1);
        ListNode smallHead = smallNode, bigHead = bigNode, p = head;
        while (p != null) {
            if (p.val >= x) {
                bigHead.next = new ListNode(p.val);
                bigHead = bigHead.next;
            } else {
                smallHead.next = new ListNode(p.val);
                smallHead = smallHead.next;
            }
            p = p.next;
        }

        // 链接两个链表
        smallHead.next = bigNode.next;
        return smallNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
