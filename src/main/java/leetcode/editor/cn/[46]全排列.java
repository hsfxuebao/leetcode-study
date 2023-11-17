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
// 👍 2747, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author hsfxuebao
 * 2023-11-16 16:15:14 
 */
class P46_Permutations{
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        // 路径
        LinkedList<Integer> track = new LinkedList<>();
        // 是否使用过
        boolean[] used = new boolean[nums.length];
        permute(nums, track, used);
        return res;
    }

        private void permute(int[] nums, LinkedList<Integer> track, boolean[] used) {
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
                permute(nums, track, used);
                // 撤销选择
                track.removeLast();
                used[i]= false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
