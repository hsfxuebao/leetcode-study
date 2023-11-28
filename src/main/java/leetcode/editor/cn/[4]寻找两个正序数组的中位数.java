package leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics数组 | 二分查找 | 分治 
//
// 👍 6905, 👎 0 
//
//
//
//

/**
 * 寻找两个正序数组的中位数
 *
 * @author hsfxuebao
 * 2023-11-28 20:17:40 
 */
class P4_MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        solution.findMedianSortedArrays(nums1, nums2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] num = new int[m+n];

        // 合并到一个数组中
        int i = 0, j = 0, k=0;
        while (i < m && j < n) {
            if (nums1[i] >= nums2[j]) {
                num[k] = nums2[j];
                j++;
                k++;
            } else {
                num[k] = nums1[i];
                i++;
                k++;
            }
        }
        while (i < m) {
            num[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            num[k] = nums2[j];
            j++;
            k++;
        }
        int sum = m+n;
        if (sum % 2 != 0) {
            return (double) num[sum / 2];
        } else {
            return (num[sum/2-1] +num[sum/2]) /2.0;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
