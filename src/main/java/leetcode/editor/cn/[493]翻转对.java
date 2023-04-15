package leetcode.editor.cn;

//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
//
// Related Topics树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序 
//
// 👍 409, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 翻转对
 *
 * @author hsfxuebao
 * 2023-04-15 16:59:03 
 */
class P493_ReversePairs{
    public static void main(String[] args) {
        Solution solution = new P493_ReversePairs().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] temp;
        int count = 0;
    public int reversePairs(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return count;

    }

        private void mergeSort(int[] nums, int lo, int hi) {

            if (lo >= hi) {
                return;
            }
            int mid = lo + (hi - lo)/2;
            mergeSort(nums, lo, mid);
            mergeSort(nums, mid+1, hi);
            merge2(nums, lo, mid, hi);

        }

        private void merge2(int[] nums, int lo, int mid, int hi) {


            for (int i = lo; i <= hi; i++) {
                temp[i] = nums[i];
            }

            // 计算翻转数组对的个数
            // todo end 放到这里 可以优化
            int end = mid+1;
            for (int i = lo; i <= mid; i++) {

                while (end <= hi && (long) nums[i] >  2 * (long) nums[end]) {
                    end++;
                }
                count += end - mid - 1;
            }

            // 排序
            int left = lo, right = mid+1;
            for (int i = lo; i <= hi; i++) {
                if (left == mid + 1) {
                    nums[i] = temp[right++];
                } else if (right == hi + 1) {
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
