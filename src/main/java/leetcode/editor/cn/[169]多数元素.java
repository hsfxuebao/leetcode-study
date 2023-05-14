package leetcode.editor.cn;

//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics数组 | 哈希表 | 分治 | 计数 | 排序 
//
// 👍 1800, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;

/**
 * 多数元素
 *
 * @author hsfxuebao
 * 2023-05-04 15:22:33 
 */
class P169_MajorityElement{
    public static void main(String[] args) {
        Solution solution = new P169_MajorityElement().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {



        /**
         * 时间复杂度 o(n)
         * 空间复杂度 o(1)
         */
        public int majorityElement1(int[] nums) {
            // 寻找的众数
            int target = 0;
            // 计数器（类比带电粒子例子中的带电性）
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    target = nums[i];
                    count = 1;
                } else if (target == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return target;

        }

        /**
         * 时间复杂度 o(n*logn)
         * 空间复杂度
         */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length /2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
