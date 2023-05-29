package leetcode.editor.cn;

//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。 
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics位运算 | 数组 | 哈希表 | 排序 
//
// 👍 331, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 错误的集合
 *
 * @author hsfxuebao
 * 2023-05-28 08:50:04 
 */
class P645_SetMismatch{
    public static void main(String[] args) {
        Solution solution = new P645_SetMismatch().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {

        // 重复的元素
        int dup = -1;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // 出现重复的元素
            if (nums[index] < 0) {
                dup = index + 1;
            } else {
                nums[index] *= -1;
            }
        }

        // 找到未出现的数字
        int mis = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                mis = i+1;
            }
        }
        return new int[]{dup, mis};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
