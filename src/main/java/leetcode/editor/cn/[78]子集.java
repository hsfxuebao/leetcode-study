package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution78 {
    /**
     * 回溯算法
     * 路径，选择，结束条件
     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        if (nums.length <= 0) {
            return res;
        }
        // 递归
        backtrack(nums, track, 0);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, int start) {
        res.add(new ArrayList<>(track));
        // 结束条件
        if (track.size() == nums.length) {
            return;
        }

        // 选择集
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 递归
            backtrack(nums, track, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

//    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        new Solution().subsets(nums);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
