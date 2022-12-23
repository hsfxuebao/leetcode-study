package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution354 {

    public int maxEnvelopes(int[][] envelopes) {
        // 排序，先以宽度升序，如果宽度相等，再以高度降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0
                       ? o2[1] - o1[1]
                       : o1[0] - o2[0];
            }
        });

        // 在以高度 寻找 最长递增子序列
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums) {

        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            // 二分查找,最左侧
            int left = 0, right = piles - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid - 1;
                } else if (poker == top[mid]) {
                    right = mid - 1;
                }
            }
            // 没有找到
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }

        return piles;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
