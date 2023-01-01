package leetcode.editor.cn;

//给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 s
//econdList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。 
//
// 返回这 两个区间列表的交集 。 
//
// 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。 
//
// 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,
//24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// 示例 2： 
//
// 
//输入：firstList = [[1,3],[5,9]], secondList = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：firstList = [], secondList = [[4,8],[10,12]]
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：firstList = [[1,7]], secondList = [[3,10]]
//输出：[[3,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 109 
// endi < starti+1 
// 0 <= startj < endj <= 109 
// endj < startj+1 
// 
// Related Topics 数组 双指针 
// 👍 348 👎 0

import java.util.LinkedList;


/**
 * 区间列表的交集
 *
 * @author hsfxuebao
 * 2023-01-01 17:23:16 
 */
class P986_IntervalListIntersections{
    public static void main(String[] args) {
        Solution solution = new P986_IntervalListIntersections().new Solution();
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        solution.intervalIntersection(firstList, secondList);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        LinkedList<int[]> result = new LinkedList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int firstStart = firstList[i][0];
            int firstEnd = firstList[i][1];
            int secondStart = secondList[j][0];
            int secondEnd = secondList[j][1];

            // 区间有相交
            if (secondEnd >= firstStart && firstEnd >= secondStart) {
                result.add(new int[]{  Math.max(firstStart, secondStart),
                                        Math.min(firstEnd, secondEnd)});
            }
            if (secondEnd < firstEnd) {
                j++;
            } else {
                i++;
            }
        }
        return result.toArray(new int[0][0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
