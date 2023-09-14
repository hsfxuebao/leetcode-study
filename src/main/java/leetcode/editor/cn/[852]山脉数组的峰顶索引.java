package leetcode.editor.cn;

//符合下列属性的数组 arr 称为 山脉数组 ：
//
// 
// arr.length >= 3 
// 存在 i（0 < i < arr.length - 1）使得： 
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
//
// 给你由整数组成的山脉数组 arr ，返回满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1]
// > ... > arr[arr.length - 1] 的下标 i 。 
//
// 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [0,1,0]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：arr = [0,2,1,0]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,10,5,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 10⁵ 
// 0 <= arr[i] <= 10⁶ 
// 题目数据保证 arr 是一个山脉数组 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 371, 👎 0 
//
//
//
//

/**
 * 山脉数组的峰顶索引
 *
 * @author hsfxuebao
 * 2023-09-14 19:41:11 
 */
class P852_PeakIndexInAMountainArray{
    public static void main(String[] args) {
        Solution solution = new P852_PeakIndexInAMountainArray().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
