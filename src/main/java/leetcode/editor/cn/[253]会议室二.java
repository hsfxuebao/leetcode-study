package leetcode.editor.cn;

import java.util.Arrays;


/**
 * @author hsfxuebao
 * Created on 2023-01-01
 *
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时
 * 间 intervals[i] = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会
 * 议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 */
class P253_minMeetingRooms {

    public static void main(String[] args) {

    }

    class Solution {
        // 返回需要申请的会议室数量
        int minMeetingRooms(int[][] meetings) {
            int n = meetings.length;
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = meetings[i][0];
                end[i] = meetings[i][1];
            }

            // 排序
            Arrays.sort(start);
            Arrays.sort(end);

            // 双指针扫描
            int i = 0, j = 0;
            int count = 0;
            int res = 0;
            while (i < n && j < n) {

                if (start[i] < end[j]) {
                    count++;
                    i++;
                } else {
                    count--;
                    j++;
                }
                res = Math.max(res, count);
            }
            return res;
        }

    }

}
