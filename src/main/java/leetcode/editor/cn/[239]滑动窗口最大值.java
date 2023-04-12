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
// 👍 2231, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * @author hsfxuebao
 * 2023-04-05 09:10:59 
 */
class P239_SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k +1];

        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {

            // 先填满窗口的 k-1
            if (i < k-1) {
                window.push(nums[i]);
            } else {
                // 窗口向前滑动 添加新数字
                window.push(nums[i]);
                // 记录 窗口内最大值
                res[i-k+1] = window.getMax();
                // 移除 旧数字
                window.pop(nums[i-k+1]);
            }
        }

        return res;
    }


        // 单调递减队列实现
        class MonotonicQueue {

            LinkedList<Integer> q = new LinkedList<>();

            public void push(int num) {
                // 将 小于n 的数 全部删除
                while (!q.isEmpty() && q.getLast() < num) {
                    q.pollLast();
                }
                // 然后将n加入 尾部
                q.addLast(num);
            }

            public int getMax() {
                return q.getFirst();
            }

            public void pop(int num) {
                if (q.getFirst() == num) {
                    q.pollFirst();
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
