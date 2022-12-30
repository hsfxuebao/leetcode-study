package leetcode.editor.cn;

//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
// Related Topics 数组 回溯 
// 👍 2293 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * @author hsfxuebao
 * 2022-12-30 10:31:31 
 */
class P39_CombinationSum{
    public static void main(String[] args) {
        Solution solution = new P39_CombinationSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 递归
        backtrack(candidates, 0, track, target);
        return res;
    }

        private void backtrack(int[] candidates, int start, LinkedList<Integer> track, int target) {
            // 结束条件
            if (target == 0) {
                res.add(new ArrayList<>(track));
                return;
            }
            // 选择集
            for (int i = start; i < candidates.length; i++) {

                if (target - candidates[i] < 0) {
                    continue;
                }
                // 做选择
                track.add(candidates[i]);
                // todo 元素 可以被重复使用，递归使用i
                backtrack(candidates, i, track, target - candidates[i]);
                // 撤销选择
                track.removeLast();
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
