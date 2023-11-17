package leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1170, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 *
 * @author hsfxuebao
 * 2023-11-16 20:12:47 
 */
class P90_SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new P90_SubsetsIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 路径
        LinkedList<Integer> track = new LinkedList<>();
        //
        backtrack(nums, 0, track);
        return res;
    }

        private void backtrack(int[] nums, int startIndex, LinkedList<Integer> track) {
            res.add(new ArrayList<>(track));

            for (int i = startIndex; i < nums.length; i++) {

                // 跳过重复的数据
                if (i > startIndex && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 选择
                track.add(nums[i]);
                backtrack(nums, i+1, track);
                // 撤销选择
                track.removeLast();

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
