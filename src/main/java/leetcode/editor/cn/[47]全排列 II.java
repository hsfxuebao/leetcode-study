package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1386, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 *
 * @author hsfxuebao
 * 2023-06-23 10:49:56 
 */
class P47_PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47_PermutationsIi().new Solution();
        int[] nums = new int[]{1,1,2};
        solution.permuteUnique(nums);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 有重复元素 不可复选
         */
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

        private void backtrack(int[] nums, boolean[] used) {

            if (track.size() == nums.length) {
                res.add(new ArrayList<>(track));
                return;
            }

            // 选择集
            for (int i = 0; i < nums.length; i++) {

                if (used[i]) {
                    continue;
                }
                // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
                if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                    continue;
                }

                // 选择
                track.addLast(nums[i]);
                used[i] = true;
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
