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
// 👍 1480, 👎 0 
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
 * 有重复元素  不可复选  组合
 *
 * @author hsfxuebao
 * 2023-11-19 10:41:56 
 */
class P40_CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40_CombinationSumIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, 0, track, target);
        return res;

    }

        private void backtrack(int[] candidates, int startIndex, LinkedList<Integer> track, int target) {

            if (target == 0) {
                res.add(new ArrayList<>(track));
                return;
            }
            if (target < 0) {
                return;
            }

            // 选择集
            for (int i = startIndex; i < candidates.length; i++) {
                if (i > startIndex && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                track.add(candidates[i]);
                backtrack(candidates, i+1, track, target-candidates[i]);
                track.removeLast();
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
