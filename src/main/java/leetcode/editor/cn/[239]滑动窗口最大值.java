package leetcode.editor.cn;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics队列 | 数组 | 滑动窗口 | 单调队列 | 堆（优先队列） 
//
// 👍 2617, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 滑动窗口最大值
 *
 * @author hsfxuebao
 * 2023-11-27 09:49:56 
 */
class P239_SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        MonotonicQueue queue = new MonotonicQueue();

        for (int i = 0; i < k-1; i++) {
            queue.push(nums[i]);
        }

       int left = 0, right = k-1;
        while (right < nums.length) {

            queue.push(nums[right]);
            right++;

            res.add(queue.max());

            queue.pop(nums[left++]);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }




    class MonotonicQueue{

        private LinkedList<Integer> maxQ = new LinkedList<>();

        public void push(int value){

            while (!maxQ.isEmpty() && maxQ.getLast() < value) {
                maxQ.removeLast();
            }
            maxQ.addLast(value);

        }


        // 获取最大值
        public int max(){
            return maxQ.getFirst();
        }

        public void pop(int n){
            if (n == maxQ.getFirst()) {
                maxQ.pop();
            }
        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
