package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 2233, 👎 0 
//
//
//
//

/**
 * 移动零
 *
 * @author hsfxuebao
 * 2023-11-25 21:37:29 
 */
class P283_MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new P283_MoveZeroes().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {

        int left = 0, right = 0;
        while (right < nums.length) {

            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        // 将left 后面的元素 用0填充
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
