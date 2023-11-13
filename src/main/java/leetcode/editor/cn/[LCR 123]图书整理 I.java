package leetcode.editor.cn;

//书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放
//回到书架上。请倒序返回这个书单链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [3,6,4,1]
//
//输出：[1,4,6,3]
// 
//
// 
//
// 提示： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 468, 👎 0 
//
//
//
//

import java.util.LinkedList;
import java.util.Stack;


import common.ListNode;

/**
 * 图书整理 I
 *
 * @author hsfxuebao
 * 2023-11-13 19:09:21 
 */
class PLCR_123_CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {

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
    public int[] reverseBookList(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
