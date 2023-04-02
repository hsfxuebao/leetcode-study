package leetcode.editor.cn;

//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics数组 | 双指针 | 二分查找 | 排序 | 滑动窗口 | 堆（优先队列） 
//
// 👍 483, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 *
 * @author hsfxuebao
 * 2023-04-02 15:47:34 
 */
class P658_FindKClosestElements{
    public static void main(String[] args) {
        Solution solution = new P658_FindKClosestElements().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {



        int p = leftBound(arr, x);
        int left = p -1, right = p;

        LinkedList<Integer> result = new LinkedList<>();
        while (right - left - 1 < k) {
            if (left == -1) {
                result.addLast(arr[right]);
                right++;
            } else if (right == arr.length) {
                result.addFirst(arr[left]);
                left--;
            } else if (x - arr[left] > arr[right] - x) {
                result.addLast(arr[right]);
                right++;
            } else {
                result.addFirst(arr[left]);
                left--;
            }
        }
        return result;
    }

        private int leftBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left)/2;

                if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
