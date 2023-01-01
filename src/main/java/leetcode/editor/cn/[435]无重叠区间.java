package leetcode.editor.cn;

//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 105 
// intervals[i].length == 2 
// -5 * 104 <= starti < endi <= 5 * 104 
// 
// Related Topics 贪心 数组 动态规划 排序 
// 👍 860 👎 0

import java.util.Arrays;

/**
 * 无重叠区间
 *
 * @author hsfxuebao
 * 2023-01-01 09:52:40 
 */
class P435_NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new P435_NonOverlappingIntervals().new Solution();
        int[][] intervals = {{1,2},{2,3},{3,4},{-100,-2},{5,7}};
        solution.eraseOverlapIntervals(intervals);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        return intervals.length - intervalSchedule(intervals);

    }

        /**
         * 无重叠区间个数
         */
        public int intervalSchedule(int[][] intervals) {

            // 按结束时间 升序
            Arrays.sort(intervals, (int[] a, int[] b) -> {
                return a[1] - b[1];
            });
            // 至少有一个区间 不重叠
            int res = 1;
            int end = intervals[0][1];
            for (int[] interval : intervals) {
                int start = interval[0];
                // todo 大于等于
                if (start >= end) {
                    res++;
                    end = interval[1];
                }
            }
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
