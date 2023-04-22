package leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1753 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import sun.awt.image.ImageWatched.Link;

/**
 * 合并区间
 *
 * @author hsfxuebao
 * 2023-01-01 17:13:54 
 */
class P56_MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56_MergeIntervals().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        // 按start升序
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        List<int[]> result = new ArrayList<>();
        // 放入第一个数组
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] nums = intervals[i];
            // 找到 result 中最后一个元素
            int[] res = result.get(result.size() - 1);
            // 两个区间相交，更新end值
            if (nums[0] <= res[1]) {
                res[1] = Math.max(nums[1], res[1]);
            } else {
                // 新的一个区间
                result.add(nums);
            }

        }
        return result.toArray(new int[0][0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
