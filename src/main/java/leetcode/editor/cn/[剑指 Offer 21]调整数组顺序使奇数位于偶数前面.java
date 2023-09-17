package leetcode.editor.cn;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 290, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author hsfxuebao
 * 2023-04-05 10:50:20 
 */
class P_Offer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new P_Offer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] exchange(int[] nums) {

           int slow = 0, fast = 0;
            while (fast < nums.length) {

                // fast 是奇数
                if (nums[fast]%2 == 1) {
                    // 互换位置
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
                fast++;
            }
            return nums;
        }

    public int[] exchange1(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            // 奇数
            if (nums[left] % 2 != 0) {
                left++;
            } else {
                // right 是偶数
                while (right > 0 && nums[right] % 2 == 0) {
                    right--;
                }
                // 如果 right 小于left 可以跳出循环了
                if (left >= right) {
                    break;
                }
                // 位置互换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }

        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
