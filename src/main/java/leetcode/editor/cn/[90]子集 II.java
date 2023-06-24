package leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1116, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 *
 * @author hsfxuebao
 * 2023-06-23 10:35:19 
 */
class P90_SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new P90_SubsetsIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 有重复元素 不可复选
         */
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;

    }

        private void backtrack(int[] nums, int start) {

            res.add(new ArrayList<>(track));

            // 选择集
            for (int i = start; i < nums.length; i++) {

                // 剪枝逻辑，去除重复的元素
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 选择
                track.addLast(nums[i]);
                // 递归
                backtrack(nums, i+1);
                // 撤销选择
                track.removeLast();

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
