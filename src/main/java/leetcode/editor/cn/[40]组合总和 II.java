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
// Related Topics 数组 回溯 
// 👍 1196 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 *
 * @author hsfxuebao
 * 2022-12-30 10:00:36 
 */
class P40_CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40_CombinationSumIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 回溯算法
         * 路径 选择 结束条件
         */
        private List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // 排序 升序
            Arrays.sort(candidates);
            // 记录 路径
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(candidates, 0, track, target);
            return res;
        }

        private void backtrack(int[] candidates, int start, LinkedList<Integer> track, int target) {


            if (target == 0) {
                res.add(new ArrayList<>(track));
                return;
            }
            // 选择集
            for (int i = start; i < candidates.length; i++) {
                // 剪枝 重复元素 只遍历第一个
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                // 不符合条件
                if (target - candidates[i] < 0) {
                    continue;
                }
                // 做选择
                track.add(candidates[i]);
                // 递归
                backtrack(candidates, i+1, track, target - candidates[i]);
                // 撤销选择
                track.removeLast();

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
