package leetcode.editor.cn;

//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 数组 单调栈 
// 👍 745 👎 0

import java.util.Stack;

/**
 * 下一个更大元素 II
 *
 * @author hsfxuebao
 * 2023-01-07 09:57:55 
 */
class P503_NextGreaterElementIi{
    public static void main(String[] args) {
        Solution solution = new P503_NextGreaterElementIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 大单调栈 使用循环数组  不构造2倍的新数组
         */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2*n -1; i >= 0 ; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
