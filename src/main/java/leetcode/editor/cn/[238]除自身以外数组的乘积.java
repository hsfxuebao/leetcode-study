package leetcode.editor.cn;

//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
//
// Related Topics数组 | 前缀和 
//
// 👍 1414, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 除自身以外数组的乘积
 *
 * @author hsfxuebao
 * 2023-04-13 21:34:41 
 */
class P238_ProductOfArrayExceptSelf{
    public static void main(String[] args) {
        Solution solution = new P238_ProductOfArrayExceptSelf().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];

            // result 存放前缀乘积
            result[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                result[i] = nums[i-1] * result[i-1];
            }

            int right = 1;
            for (int i = nums.length-1; i >= 0; i--) {

                result[i] = result[i] * right;
                right = right * nums[i];
            }

            return result;

        }
    public int[] productExceptSelf1(int[] nums) {

        // 从左到右 0-i乘积
        int[] prefix = new int[nums.length];
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            pre *= nums[i];
            prefix[i] = pre;
        }

        // 从右到左 i-nums.leng-1的乘积
        int[] suffix = new int[nums.length];
        int suf = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suf *= nums[i];
            suffix[i] = suf;
        }

        int[] result = new int[nums.length];

        result[0] = suffix[1];
        result[nums.length - 1] = prefix[nums.length - 2];


        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = prefix[i-1] * suffix[i+1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
