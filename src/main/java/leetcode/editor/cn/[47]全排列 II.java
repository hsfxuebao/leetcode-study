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
// Related Topics 数组 回溯 
// 👍 1254 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 *
 * @author hsfxuebao
 * 2022-12-30 10:12:27 
 */
class P47_PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47_PermutationsIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 记录 路径
        LinkedList<Integer> track = new LinkedList<>();
        // 当前元素 是否被使用过
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

        private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {

            // 终止条件
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            // 选择集
            for (int i = 0; i < nums.length; i++) {

                // 过滤 使用过的元素
                if (used[i]) {
                    continue;
                }

                // 剪枝逻辑  遇到重复的元素，前面的元素被使用了，才可以使用
                if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                    continue;
                }
                // 做选择
                used[i] = true;
                track.addLast(nums[i]);
                backtrack(nums, track, used);
                // 撤销选择
                used[i] = false;
                track.removeLast();

            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
