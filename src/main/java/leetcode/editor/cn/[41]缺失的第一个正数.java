package leetcode.editor.cn;

//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics数组 | 哈希表 
//
// 👍 1825, 👎 0 
//
//
//
//

/**
 * 缺失的第一个正数
 *
 * @author hsfxuebao
 * 2023-05-21 09:21:11 
 */
class P41_FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new P41_FirstMissingPositive().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // 对于数组中的负数 换成n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n+1;
            }
        }

        // 将nums[i] 对应的索引位置 改成负数，标记一下
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }

        // 出现的第一个大于0 的数就是缺失的第一个正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return n+1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
