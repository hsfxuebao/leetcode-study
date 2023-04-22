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
//
// Related Topics数组 | 排序 
//
// 👍 96, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;
import java.util.Comparator;

/**
 * 删除被覆盖区间
 *
 * @author hsfxuebao
 * 2023-04-21 21:18:02 
 */
class P1288_RemoveCoveredIntervals{
    public static void main(String[] args) {
        Solution solution = new P1288_RemoveCoveredIntervals().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        // 按照起点升序排序，若起点相同降序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1]
                                      : o1[0] - o2[0];
            }
        });

        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] nums = intervals[i];

            // 1. 找到覆盖区间
            if (left <= nums[0] && nums[1] <= right) {
                count++;
            }
            // 2. 合并区间
            if (right >= nums[0] && right <= nums[1]) {
               right = nums[1];
            }
            // 3. 两个不相交区间
            if (right < nums[0]) {
                left = nums[0];
                right = nums[1];
            }
        }
        return intervals.length - count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
