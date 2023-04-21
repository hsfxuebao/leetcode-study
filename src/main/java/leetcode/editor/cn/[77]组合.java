package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1357, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 *
 * @author hsfxuebao
 * 2023-04-21 09:36:45 
 */
class P77_Combinations{
    public static void main(String[] args) {
        Solution solution = new P77_Combinations().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 无重复元素  组合问题
         */
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        backtrack(nums, 0, k);
        return result;
    }

        private void backtrack(int[] nums, int start, int k) {

            // 终止条件
            if (track.size() == k) {
                result.add(new LinkedList<>(track));
                return;
            }

            // 选择集
            for (int i = start; i < nums.length; i++) {
                // 做选择
                track.addLast(nums[i]);
                backtrack(nums, i+1, k);
                // 撤销选择
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
