package leetcode.editor.cn;

//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics数组 | 二分查找 | 动态规划 | 排序 
//
// 👍 884, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 *
 * @author hsfxuebao
 * 2023-04-02 10:03:37 
 */
class P354_RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new P354_RussianDollEnvelopes().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // 先按宽度 升序排序，若相同按高度降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]
                        ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        // 对高度维度 求 最长递增子序列
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
            // 动态规划解法
//        return lengOfLIS(height);
        // 二分查找解法
        return lengOfLIS2(height);

    }

        // 找 最左侧边界
        private int lengOfLIS2(int[] height) {

            int[] top = new int[height.length+1];
            // 牌堆数
            int piles = 0;
            for (int i = 0; i < height.length; i++) {
                int target = height[i];
                int left = 0, right = piles;

                while (left < right) {
                    int mid = left + (right - left)/2;
                    if (top[mid] > target) {
                        right = mid;
                    } else if (top[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (left == piles) {
                    // 堆数 +1
                    piles++;
                }
                top[left] = target;
            }
            return piles;
        }

        // 动态规划
        private int lengOfLIS(int[] height) {
            int[] dp = new int[height.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < height.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (height[i] > height[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
