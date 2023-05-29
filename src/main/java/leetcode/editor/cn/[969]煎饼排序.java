package leetcode.editor.cn;

//给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。 
//
// 一次煎饼翻转的执行过程如下： 
//
// 
// 选择一个整数 k ，1 <= k <= arr.length 
// 反转子数组 arr[0...k-1]（下标从 0 开始） 
// 
//
// 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。 
//
// 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断
//为正确。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,4,1]
//输出：[4,2,4,3]
//解释：
//我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
//初始状态 arr = [3, 2, 4, 1]
//第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
//第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
//第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
//第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。 
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3]
//输出：[]
//解释：
//输入已经排序，因此不需要翻转任何内容。
//请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= arr.length 
// arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列） 
// 
//
// Related Topics贪心 | 数组 | 双指针 | 排序 
//
// 👍 304, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

/**
 * 煎饼排序
 *
 * @author hsfxuebao
 * 2023-05-26 20:30:49 
 */
class P969_PancakeSorting{
    public static void main(String[] args) {
        Solution solution = new P969_PancakeSorting().new Solution();
        int[] arr = {3,2,4,1};
        solution.pancakeSort(arr);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr) {

        sort(arr, arr.length);
        return res;

    }

        private void sort(int[] arr, int n) {

            if (n == 1) {
                return;
            }

            // 先找到1-n 中最大的索引
            int maxIndex = 0;
            int maxNum = 0;
            for (int i = 0; i < n; i++) {
                if (maxNum < arr[i]) {
                    maxIndex = i;
                    maxNum = arr[i];
                }
            }
            // 把该数 反转到 最后的位置
            // 先反转 0-maxIndex 之间的数字
            reverse1(arr, 0, maxIndex);
            res.add(maxIndex+1);
            // 再反转
            reverse1(arr, 0, n-1);
            res.add(n);
            // 递归 n-1
            sort(arr, n-1);

        }

        private void reverse1(int[] arr, int left, int right) {

            while (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
