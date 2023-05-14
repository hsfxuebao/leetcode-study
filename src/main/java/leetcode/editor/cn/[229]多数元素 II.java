package leetcode.editor.cn;

//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
//
// Related Topics数组 | 哈希表 | 计数 | 排序 
//
// 👍 675, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

/**
 * 多数元素 II
 *
 * @author hsfxuebao
 * 2023-05-14 16:29:47 
 */
class P229_MajorityElementIi{
    public static void main(String[] args) {
        Solution solution = new P229_MajorityElementIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 摩尔投票法
         * 时间复杂度 o(n)
         * 空间复杂度 o(1)
         */
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();

        int target1 = 0, target2 = 0;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count1 > 0 && target1 == nums[i]) {

                count1++;
            } else if (count2 > 0 && target2 == nums[i]) {

                count2++;
            } else if (count1 == 0) {
                target1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                target2 = nums[i];
                count2++;
                // 都不相等 都减1
            } else {
                count1--;
                count2--;
            }
        }

        int nums1 = 0, nums2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target1 == nums[i]) {
                nums1++;
            }
            if (target2 == nums[i]) {
                nums2++;
            }
        }
        if (count1 > 0 && nums1 > nums.length / 3) {
            result.add(target1);
        }
        if (count2 > 0 && nums2 > nums.length / 3) {
            result.add(target2);
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
