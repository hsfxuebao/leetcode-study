package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution77 {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯算法
     * 路径 选择 结束条件
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0) {
            return res;
        }
        // 初始化nums数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track, k);
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track, int k) {
        // 结束条件
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        // 选择集
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 递归
            backtrack(nums, i + 1, track, k);
            // 撤销选择
            track.removeLast();
        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)
