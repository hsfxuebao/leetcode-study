package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics数组 | 哈希表 | 滑动窗口 
//
// 👍 593, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存在重复元素 II
 *
 * @author hsfxuebao
 * 2023-05-14 18:27:55 
 */
class P219_ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new P219_ContainsDuplicateIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> val2IndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            val2IndexMap.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> indexList = val2IndexMap.get(nums[i]);
            for (Integer index : indexList) {
                if (i - index <= k) {
                    return true;
                }
            }
            indexList.add(i);

        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
