package leetcode.editor.cn;

//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics数组 | 分治 | 桶排序 | 计数排序 | 基数排序 | 排序 | 堆（优先队列） | 归并排序 
//
// 👍 826, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Random;

/**
 * 排序数组
 *
 * @author hsfxuebao
 * 2023-04-15 19:21:28 
 */
class P912_SortAnArray{
    public static void main(String[] args) {
        Solution solution = new P912_SortAnArray().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 快排
         */
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            // 为避免出现极端情况，先随机打乱
            shuffle1(nums);
            quickSort1(nums, 0, nums.length - 1);
            return nums;

        }

        private void shuffle1(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                int p = i + new Random().nextInt(nums.length - i);
                swap(nums, i, p);
            }

        }
        private void swap(int[] nums, int i, int j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }

        private void quickSort1(int[] nums, int lo, int hi) {

            if (lo >= hi) {
                return;
            }
            // 对 nums[lo..hi] 进行切分
            // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
            int p = partition1(nums, lo, hi);
            quickSort1(nums, lo, p -1);
            quickSort1(nums, p+1, hi);


        }

        private int partition1(int[] nums, int lo, int hi) {
            int pivot = nums[lo];
            int left = lo + 1, right = hi;
            // 当 left > right 时结束循环，以保证区间 [lo, hi] 都被覆盖
            while (left <= right) {

                while (left <= hi && nums[left] <= pivot) {
                    left++;
                    // 此 while 结束时恰好 nums[i] > pivot
                }
                while (right > lo && nums[right] > pivot) {
                    right--;
                    // 此 while 结束时恰好 nums[j] <= pivot
                }
                // 此时 [lo, i) <= pivot && (j, hi] > pivot
                if (left >= right) {
                    break;
                }

                swap(nums, left, right);
            }
            // 将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
            swap(nums, lo, right);
            return right;
        }

        /**
         * 归并排序
         */
        int[] temp;
    public int[] sortArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        temp = new int[nums.length];
        mergeSort1(nums, 0, nums.length - 1);
        return nums;
    }

        private void mergeSort1(int[] nums, int lo, int hi) {

            if (lo >= hi) {
                return;
            }
            int mid = lo + (hi - lo)/2;
            mergeSort1(nums, lo, mid);
            mergeSort1(nums, mid+1, hi);
            merge1(nums, lo, mid, hi);
        }
        private void merge1(int[] nums, int lo, int mid, int hi) {

            for (int i = lo; i <= hi; i++) {
                temp[i] = nums[i];
            }

            int left = lo, right = mid+1;
            for (int i = lo; i <= hi ; i++) {
                if (left == mid + 1) {
                    nums[i] = temp[right++];
                } else if (right == hi+1) {
                    nums[i] = temp[left++];
                } else if (temp[left] > temp[right]) {
                    nums[i] = temp[right++];
                } else {
                    nums[i] = temp[left++];
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
