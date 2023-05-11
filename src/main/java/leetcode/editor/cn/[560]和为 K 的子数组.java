package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 1918, 👎 0 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 *
 * @author hsfxuebao
 * 2023-05-09 21:02:56 
 */
class P560_SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new P560_SubarraySumEqualsK().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> preSum2Num = new HashMap<>();
        preSum2Num.put(0, 1);
        int preSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSum2Num.containsKey(preSum - k)) {
                count += preSum2Num.get(preSum-k);
            }
            preSum2Num.put(preSum, preSum2Num.getOrDefault(preSum, 0) + 1);
        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
