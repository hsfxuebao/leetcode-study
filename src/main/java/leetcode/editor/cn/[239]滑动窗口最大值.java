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
// 👍 2509, 👎 0 
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
 * 2023-09-14 21:08:34 
 */
class P239_SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue monotonicQueue = new MonotonicQueue();
        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;


        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monotonicQueue.push(nums[i]);
            } else {
                monotonicQueue.push(nums[i]);
                result.add(monotonicQueue.max());
                monotonicQueue.pop(nums[i-k+1]);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }


        public class MonotonicQueue {

            LinkedList<Integer> queue = new LinkedList();

            public void push(int num) {

                while (!queue.isEmpty() && queue.getLast() < num) {
                    queue.removeLast();
                }
                queue.addLast(num);
            }

            public void pop(int num) {
                if (num == queue.getFirst()) {
                    queue.removeFirst();
                }
            }
            public int max() {
                return queue.getFirst();
            }


        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
