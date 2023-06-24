package leetcode.editor.cn;

//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 693, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 *
 * @author hsfxuebao
 * 2023-06-23 09:10:33 
 */
class P216_CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new P216_CombinationSumIii().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 无重复元素 不可复选
         */

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 构建数组
        int[] nums = new int[9];
        for (int i = 1; i <= 9; i++) {
            nums[i-1] = i;
        }

        backtrack(nums, n, k, 0);
        return result;

    }

        private void backtrack(int[] nums, int remind, int k, int start) {
            if (track.size() == k) {
                if (remind == 0) {
                    result.add(new ArrayList<>(track));
                }
                return;
            }
            if (track.size() > k) {
                return;
            }

            // 选择集
            for (int i = start; i < nums.length; i++) {

                // 选择
                track.addLast(nums[i]);
                // 递归
                backtrack(nums, remind - nums[i], k, i+1);
                // 撤销选择
                track.removeLast();

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
