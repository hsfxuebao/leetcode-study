package leetcode.editor.cn;

//有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示
//水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。 
//
// 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xs
//tart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。 
//
// 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[10,16],[2,8],[1,6],[7,12]]
//输出：2
//解释：气球可以用2支箭来爆破:
//-在x = 6处射出箭，击破气球[2,8]和[1,6]。
//-在x = 11处发射箭，击破气球[10,16]和[7,12]。 
//
// 示例 2： 
//
// 
//输入：points = [[1,2],[3,4],[5,6],[7,8]]
//输出：4
//解释：每个气球需要射出一支箭，总共需要4支箭。 
//
// 示例 3： 
//
// 
//输入：points = [[1,2],[2,3],[3,4],[4,5]]
//输出：2
//解释：气球可以用2支箭来爆破:
//- 在x = 2处发射箭，击破气球[1,2]和[2,3]。
//- 在x = 4处射出箭，击破气球[3,4]和[4,5]。 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= points.length <= 105 
// points[i].length == 2 
// -231 <= xstart < xend <= 231 - 1 
// 
// Related Topics 贪心 数组 排序 
// 👍 712 👎 0

import java.util.Arrays;

/**
 * 用最少数量的箭引爆气球
 *
 * @author hsfxuebao
 * 2023-01-01 10:04:16 
 */
class P452_MinimumNumberOfArrowsToBurstBalloons{
    public static void main(String[] args) {
        Solution solution = new P452_MinimumNumberOfArrowsToBurstBalloons().new Solution();
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        solution.findMinArrowShots(points);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {
        return intervalSchedule(points);
    }

        /**
         * 无重叠区间个数
         */
        public int intervalSchedule(int[][] intervals) {
            if (intervals.length <= 0) {
                return 0;
            }
            // 按结束时间 升序
            // todo 减法可能会造成数据溢出
            Arrays.sort(intervals, (int[] a, int[] b) -> {
                if (a[1] > b[1]) {
                    return 1;
                } else if (a[1] == b[1]) {
                    return 0;
                } else {
                    return -1;
                }
            });

            int res = 1;
            int end = intervals[0][1];
            for (int[] interval : intervals) {
                int start = interval[0];
                // todo 大于
                if (start > end) {
                    res++;
                    end = interval[1];
                }
            }
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
