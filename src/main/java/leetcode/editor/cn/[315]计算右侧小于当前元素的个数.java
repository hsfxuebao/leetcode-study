package leetcode.editor.cn;

//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序 
//
// 👍 966, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import static sort.N_05_MergeSort.mergeSort;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 *
 * @author hsfxuebao
 * 2023-04-14 20:59:10 
 */
class P315_CountOfSmallerNumbersAfterSelf{
    public static void main(String[] args) {
        Solution solution = new P315_CountOfSmallerNumbersAfterSelf().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        Pair[] temp;
        int[] count;

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        count = new int[nums.length];
        temp = new Pair[nums.length];
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        mergeSort(pairs, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }

        private void mergeSort(Pair[] pairs, int lo, int hi) {

            if (lo >= hi) {
                return;
            }
            int mid = lo + (hi - lo)/2;
            mergeSort(pairs, lo, mid);
            mergeSort(pairs, mid+1, hi);
            // 后序位置，将两个有序数组进行排序
            merge(pairs, lo, mid, hi);

        }

        private void merge(Pair[] pairs, int lo, int mid, int hi) {

            // 将原始数据保存到temp中
            for (int i = lo; i <= hi; i++) {
                temp[i] = pairs[i];
            }

            // 定义左边有序数组的开始  右边有序数组的开始位置
            int left = lo, right = mid+1;

            for (int i = lo; i <= hi; i++) {

                // 左边到最后的位置
                if (left == mid + 1) {
                    pairs[i] = temp[right++];

                    // 右边到最后的位置
                } else if (right == hi + 1) {
                    pairs[i] = temp[left++];
                    count[pairs[i].getIndex()] += right  - mid - 1;

                    // 左边大
                } else if (temp[left].getValue() > temp[right].getValue()) {
                    pairs[i] = temp[right++];

                    // 右边大
                } else {
                    pairs[i] = temp[left++];
                    count[pairs[i].getIndex()] += right - mid - 1;
                }

            }
        }


    }

    class Pair {

        // 当前数组中元素的值
        private int value;
        // 当前数组元素值 所在数组中的index
        private int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        public int getValue() {
            return value;
        }
        public int getIndex() {
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
