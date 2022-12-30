package leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
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
// 
// Related Topics 位运算 数组 回溯 
// 👍 990 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 *
 * @author hsfxuebao
 * 2022-12-30 09:46:14 
 */
class P90_SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new P90_SubsetsIi().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 回溯算法
     * 路径 选择 结束条件
     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // 排序 升序
        Arrays.sort(nums);
        // 记录 路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;

    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {

        res.add(new ArrayList<>(track));
        // 结束条件
        if (track.size() == nums.length) {
            return;
        }
        // 选择集
        for (int i = start; i < nums.length; i++) {
            // 剪枝, 值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

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

