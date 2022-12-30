package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Solution46 {

    // 记录结果集
    List<List<Integer>> result = new ArrayList<>();
    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public List<List<Integer>> permute(int[] nums) {

        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 记录 已经使用过的元素 避免重复使用
        boolean[] used = new boolean[nums.length];

        // 递归函数
        backtrack(nums, track, used);
        return result;

    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {

        // 结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        // 选择集
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法选择
            if (used[i]) {
                continue;
            }
            // 做选择
            used[i] = true;
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 撤销选择
            used[i] = false;
            track.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
