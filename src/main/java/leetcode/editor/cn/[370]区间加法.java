package leetcode.editor.cn;

import common.Difference;

/**
 * 问题：假设你有一个长度为n的数组，初始情况下所有的数字均为0，你将会被给出
 * k个更新的操作，其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组A[startIndex..
 * .endIndex]增加inc，请返回k次操作后的数组。输入：length=5，updates=[[1,3,2],[2,4,3],[0,2,-2]]，输出：[-2,0,3,5,3]。
 *
 * 解答：若每次for循环给区间[startIndex, endIndex]加上inc，那么会频繁对原始数组进行更新，效率非常低，时间复杂度为O(N)。
 *
 * 优化为：一个差分数组，存储前后两个元素之间的差，令diff[startIndex] += inc；diff[endIndex + 1] -=inc，由此实现给出数组的第一个元素值和差分数组，就能求出整个数组，时间复杂度为O(1)。

 */

class Solution370 {


    int[] getModifiedArray(int length, int[][] updates) {
        // nums初始化都为0
        int[] nums = new int[length];
        Difference difference = new Difference(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            difference.increment(i, j, val);
        }
        return difference.result();

    }
}

