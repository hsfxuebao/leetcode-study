package leetcode.editor.cn;

//给你一个按 非递减顺序 排列的整数数组 nums 。 
//
// 请你判断是否能在将 nums 分割成 一个或多个子序列 的同时满足下述 两个 条件： 
//
// 
// 
// 
// 每个子序列都是一个 连续递增序列（即，每个整数 恰好 比前一个整数大 1 ）。 
// 所有子序列的长度 至少 为 3 。 
// 
// 
// 
//
// 如果可以分割 nums 并满足上述条件，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,3,4,5]
//输出：true
//解释：nums 可以分割成以下子序列：
//[1,2,3,3,4,5] --> 1, 2, 3
//[1,2,3,3,4,5] --> 3, 4, 5
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,3,4,4,5,5]
//输出：true
//解释：nums 可以分割成以下子序列：
//[1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
//[1,2,3,3,4,4,5,5] --> 3, 4, 5
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,4,4,5]
//输出：false
//解释：无法将 nums 分割成长度至少为 3 的连续递增子序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -1000 <= nums[i] <= 1000 
// nums 按非递减顺序排列 
// 
//
// Related Topics贪心 | 数组 | 哈希表 | 堆（优先队列） 
//
// 👍 432, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

/**
 * 分割数组为连续子序列
 *
 * @author hsfxuebao
 * 2023-05-26 19:30:41 
 */
class P659_SplitArrayIntoConsecutiveSubsequences{
    public static void main(String[] args) {
        Solution solution = new P659_SplitArrayIntoConsecutiveSubsequences().new Solution();
        int[] nums = {1,2,3,3,4,5};
        solution.isPossible(nums);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {

        // 维护 每个数 在nums出现的次数
        Map<Integer, Integer> numFreMap = new HashMap<>();
        // 维护每个数作为结尾的连续子序列的需求量
        Map<Integer, Integer> needMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numFreMap.put(nums[i], numFreMap.getOrDefault(nums[i], 0)+1);
        }

        for (int num : nums) {

            // 该数  已经使用完毕了
            if (numFreMap.get(num) <= 0) {
                continue;
            }

            // 尝试将 num放到其他子序列后面
            if (needMap.containsKey(num) && needMap.get(num) > 0) {
                // num 可以放到 之前的某个序列之后
                numFreMap.put(num, numFreMap.get(num)-1);
                needMap.put(num,needMap.get(num) - 1);
                needMap.put(num+1, needMap.getOrDefault(num+1, 0)+1);
            } else if (numFreMap.getOrDefault(num + 1, 0) > 0
                    && numFreMap.getOrDefault(num + 2, 0) > 0) {
                // 第二种情况，新建一个长度为 3 的子序列 [num, num+1, num+2]
                numFreMap.put(num, numFreMap.get(num)-1);
                numFreMap.put(num+1, numFreMap.get(num+1)-1);
                numFreMap.put(num+2, numFreMap.get(num+2)-1);
                needMap.put(num+3, needMap.getOrDefault(num+3, 0)+1);
            } else {
                // 两种情况都不符合 不能分配
                return false;
            }
        }

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
