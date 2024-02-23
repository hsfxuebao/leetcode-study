package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2191, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * @author hsfxuebao
 * 2023-11-19 10:33:44 
 */
class P78_Subsets{
    public static void main(String[] args) {
        Solution solution = new P78_Subsets().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();

        // 无重复元素 不可复选 子集
    public List<List<Integer>> subsets(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;

    }

        private void backtrack(int[] nums, int start, LinkedList<Integer> track) {

            res.add(new ArrayList<>(track));

            // 选择集
            for (int i = start; i < nums.length; i++) {

                // 选择
                track.add(nums[i]);
                // 递归
                backtrack(nums, i+1, track);
                // 撤销选择
                track.removeLast();

            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
