package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2014, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * @author hsfxuebao
 * 2023-04-21 09:29:41 
 */
class P78_Subsets{
    public static void main(String[] args) {
        Solution solution = new P78_Subsets().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 无重复元素  子集问题
         */
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return result;
        }

        backtrack(nums, 0);
        return result;
    }

        private void backtrack(int[] nums, int start) {

            result.add(new LinkedList<>(track));

            // 选择集
            for (int i = start; i < nums.length; i++) {
                // 做选择
                track.addLast(nums[i]);
                backtrack(nums, i+1);

                // 撤销选择
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
