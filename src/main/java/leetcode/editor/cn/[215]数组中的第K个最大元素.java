package leetcode.editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 2140, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 数组中的第K个最大元素
 *
 * @author hsfxuebao
 * 2023-04-15 19:44:09 
 */
class P215_KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 快速选择排序
         */
        public int findKthLargest(int[] nums, int k) {

            if (nums == null || nums.length == 0 || nums.length < k) {
                return -1;
            }

            // 倒数k换成  正数 第几个数
            k = nums.length - k;

            shuffle(nums);
            int left = 0, right = nums.length - 1;
            while (left <= right) {

                int p = parition(nums, left, right);
                if (p > k) {
                    right = p - 1;
                } else if (p < k) {
                    left = p + 1;
                } else {
                    return nums[p];
                }
            }
            return -1;
        }

        private int parition(int[] nums, int lo, int hi) {
            int number = nums[lo];
            int left = lo+1, right = hi;
            while (left <= right) {

                while (left < hi && nums[left] <= number) {
                    left++;
                }
                while (right > lo && nums[right] > number) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                swap(nums, left, right);
            }
            swap(nums, lo, right);
            return right;
        }
        private void shuffle(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                int p = i+ new Random().nextInt(n - i);
                swap(nums, i, p);
            }
        }
        private void swap(int[] nums, int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
        }


        /**
         * 优先队列 小顶堆
         */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }

        }
        return queue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
