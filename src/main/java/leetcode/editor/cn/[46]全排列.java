package leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2523, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author hsfxuebao
 * 2023-04-21 09:41:37 
 */
class P46_Permutations{
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // 元素是否被使用过
        boolean[] used;

        /**
         * 元素不重复不可复用 全排列
         */
    public List<List<Integer>> permute(int[] nums) {

        used = new boolean[nums.length];

        backtrack(nums, 0);
        return result;

    }

        private void backtrack(int[] nums, int start) {

            if (track.size() == nums.length) {
                result.add(new LinkedList<>(track));
                return;
            }
            // 选择集
            for (int i = 0; i < nums.length; i++) {
                // 已经被使用过了
                if (used[i]) {
                    continue;
                }
                // 做选择
                used[i] = true;
                track.addLast(nums[i]);
                backtrack(nums, i+1);
                // 撤销选择
                used[i] = false;
                track.removeLast();

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
