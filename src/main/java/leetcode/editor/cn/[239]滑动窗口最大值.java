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

import java.util.LinkedList;
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

        // 初始化
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        for (int i = 0; i < k-1; i++) {
            monotonicQueue.push(nums[i]);
        }

        int left = 0, right = k-1;
        int[] res = new int[nums.length-k+1];
        while (right < nums.length) {

            // 放入队列中
            monotonicQueue.push(nums[right]);
            res[right - k+1] = monotonicQueue.max();

            right++;

            monotonicQueue.pop(nums[left++]);
        }
        return res;


    }




    class MonotonicQueue{

        private LinkedList<Integer> maxQ = new LinkedList<>();

        // 增加
        public void push(int val) {

            while (!maxQ.isEmpty() && maxQ.getLast() < val) {
                maxQ.removeLast();
            }
            maxQ.addLast(val);

        }
        // 查询

        public int max() {
            return maxQ.getFirst();
        }
        // 删除
        public void pop(int n) {
            if (n == maxQ.getFirst()) {
                maxQ.pop();
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
