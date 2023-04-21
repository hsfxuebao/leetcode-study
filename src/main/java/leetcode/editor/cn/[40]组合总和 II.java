package leetcode.editor.cn;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1319, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 *
 * @author hsfxuebao
 * 2023-04-21 09:58:15 
 */
class P40_CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40_CombinationSumIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        /**
         * 重复元素 不可复选
         */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return result;
    }

        private void backtrack(int[] candidates, int start, int remind) {

            if (remind == 0) {
                result.add(new LinkedList<>(track));
                return;
            }
            if (remind < 0) {
                return;
            }

            // 选择集
            for (int i = start; i < candidates.length; i++) {
                // 剪枝逻辑，值相同的树枝，只遍历第一条
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                // 做选择
                track.addLast(candidates[i]);
                backtrack(candidates, i+1, remind- candidates[i]);
                // 撤销选择
                track.removeLast();
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
