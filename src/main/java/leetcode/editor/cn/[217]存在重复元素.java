package leetcode.editor.cn;

//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics数组 | 哈希表 | 排序 
//
// 👍 1011, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素
 *
 * @author hsfxuebao
 * 2023-05-14 18:24:17 
 */
class P217_ContainsDuplicate{
    public static void main(String[] args) {
        Solution solution = new P217_ContainsDuplicate().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> val2Num = new HashMap<>();
        for (int num : nums) {
            Integer oldNum = val2Num.getOrDefault(num, 0);
            if (oldNum > 0) {
                return true;
            }
            val2Num.put(num, oldNum + 1);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
