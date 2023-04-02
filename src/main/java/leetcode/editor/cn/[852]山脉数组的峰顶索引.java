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
// 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 
//1] > ... > arr[arr.length - 1] 的下标 i 。 
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
// 示例 4： 
//
// 
//输入：arr = [3,4,5,1]
//输出：2
// 
//
// 示例 5： 
//
// 
//输入：arr = [24,69,100,99,79,78,67,36,26,19]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁶ 
// 题目数据保证 arr 是一个山脉数组 
// 
//
// 
//
// 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？ 
//
// Related Topics数组 | 二分查找 
//
// 👍 344, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 山脉数组的峰顶索引
 *
 * @author hsfxuebao
 * 2023-04-02 17:46:10 
 */
class P852_PeakIndexInAMountainArray{
    public static void main(String[] args) {
        Solution solution = new P852_PeakIndexInAMountainArray().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left)/2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
