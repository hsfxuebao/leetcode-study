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
// 👍 2072, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口最大值
 *
 * @author hsfxuebao
 * 2023-01-16 10:04:26 
 */
class P239_SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private MonotonicQueue windows = new MonotonicQueue();
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (i < k - 1) {
                //先填满窗口的前 k - 1
                windows.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                windows.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(windows.getMax());
                // 移出旧数字
                windows.pop(nums[i - k +1]);

            }
        }
        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

}

    /**
     * 单调队列的实现
     */
    class MonotonicQueue {


        private LinkedList<Integer> maxQ = new LinkedList<>();

        public void push(int value) {

            while (!maxQ.isEmpty() && maxQ.getLast() < value) {
                maxQ.removeLast();
            }
            maxQ.addLast(value);
        }

        public Integer getMax() {
            return maxQ.getFirst();
        }

        public void pop(int value) {
            if (maxQ.getFirst() == value) {
                maxQ.removeFirst();
            }
        }



    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
