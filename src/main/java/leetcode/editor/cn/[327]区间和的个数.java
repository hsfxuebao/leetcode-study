package leetcode.editor.cn;

//给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 
//upper）之内的 区间和的个数 。 
//
// 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。 
//
// 
//示例 1：
//
// 
//输入：nums = [-2,5,-1], lower = -2, upper = 2
//输出：3
//解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0], lower = 0, upper = 0
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// -10⁵ <= lower <= upper <= 10⁵ 
// 题目数据保证答案是一个 32 位 的整数 
// 
//
// Related Topics树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序 
//
// 👍 537, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 区间和的个数
 *
 * @author hsfxuebao
 * 2023-04-15 17:19:46 
 */
class P327_CountOfRangeSum{
    public static void main(String[] args) {
        Solution solution = new P327_CountOfRangeSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        long[] temp;
        int count = 0;
        public int lower;
        public int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        this.lower = lower;
        this.upper = upper;
        // 构建前缀和数组，注意 int 可能溢出，用 long 存储
        // 前缀和
        temp = new long[nums.length + 1];
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = nums[i] + preSum[i];
        }
        mergeSort1(preSum, 0, preSum.length - 1);

        return count;
    }

        private void mergeSort1(long[] preSum, int lo, int hi) {
            if (lo >= hi) {
                return;
            }
            int mid = lo + (hi - lo)/2;
            mergeSort1(preSum, lo, mid);
            mergeSort1(preSum, mid+1, hi);
            merge1(preSum, lo, mid, hi);
        }

        private void merge1(long[] preSum, int lo, int mid, int hi) {

            // 存放数据
            for (int i = lo; i <= hi; i++) {
                temp[i] = preSum[i];
            }

            // 计算区间和的个数
            int lowerEnd = mid +1, upperEnd = mid+1;
            for (int i = lo; i <= mid; i++) {

                while (lowerEnd <= hi && preSum[lowerEnd] - preSum[i] < lower) {
                    lowerEnd++;
                }
                while (upperEnd <= hi && preSum[upperEnd] - preSum[i] <= upper) {
                    upperEnd++;
                }
                count += upperEnd - lowerEnd;
            }


            // 排序
            int left = lo, right = mid+1;
            for (int i = lo; i <= hi; i++) {

                if (left == mid + 1) {
                    preSum[i] = temp[right++];
                } else if (right == hi + 1) {
                    preSum[i] = temp[left++];
                } else if (temp[left] > temp[right]) {
                    preSum[i] = temp[right++];
                } else {
                    preSum[i] = temp[left++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
