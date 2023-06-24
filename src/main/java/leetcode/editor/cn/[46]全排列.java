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
// 👍 2585, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 2023-06-23 10:41:12 
 */
class P46_Permutations{
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 无重复元素 可复选
         */
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;

    }

        private void backtrack(int[] nums, boolean[] used) {
            // 终止条件
            if (track.size() == nums.length) {
                res.add(new ArrayList<>(track));
                return;
            }

            // 选择集
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 选择
                used[i] = true;
                track.addLast(nums[i]);
                // 递归
                backtrack(nums, used);
                // 撤销选择
                track.removeLast();
                used[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
