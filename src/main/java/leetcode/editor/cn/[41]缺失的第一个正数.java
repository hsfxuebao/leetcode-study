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
// 👍 1982, 👎 0 
//
//
//
//

/**
 * 缺失的第一个正数
 *
 * @author hsfxuebao
 * 2023-11-17 09:49:11 
 */
class P41_FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new P41_FirstMissingPositive().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;
        // 现将负数和0 设置为 len+1;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len+1;
            }
        }
        // 遍历数组，将nums[i] 对应的index 设置为负数
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (index < len) {
                nums[index] = - Math.abs(nums[index]);
            }

        }
        // 遍历，找到 第一个大于0 的整数
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return len+1;


    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
