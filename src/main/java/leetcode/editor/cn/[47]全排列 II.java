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
// 👍 1497, 👎 0 
//
//
//
//

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 * 有重复元素 不可复选 全排列
 * @author hsfxuebao
 * 2023-11-19 10:52:16 
 */
class P47_PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47_PermutationsIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 排序
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, track, used);
        return res;
    }

        private void backtrack(int[] nums, int startIndex, LinkedList<Integer> track, boolean[] used) {

            if (track.size() == nums.length) {
                res.add(new ArrayList<>(track));
                return;
            }

            // 选择集
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums, i+1, track, used);
                track.removeLast();
                used[i] = false;
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
