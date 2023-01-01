package leetcode.editor.cn;

//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 数组 排序 
// 👍 88 👎 0

import java.util.Arrays;

/**
 * 删除被覆盖区间
 *
 * @author hsfxuebao
 * 2023-01-01 16:55:34 
 */
class P1288_RemoveCoveredIntervals{
    public static void main(String[] args) {
        Solution solution = new P1288_RemoveCoveredIntervals().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 按start升序，若相等end降序 排序
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] curVal = intervals[i];

            // 情况一，找到覆盖区间
            if (left <= curVal[0] && curVal[1] <= right) {
                count++;
            }
            // 情况二 出现相交区间，合并
            if (curVal[0] < right && right <= curVal[1]) {
                right = curVal[1];
            }
            // 情况三，不相交区间，更新起点和终点
            if (right < curVal[0]) {
                left = curVal[0];
                right = curVal[1];
            }

        }
        return intervals.length - count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
