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
// 👍 949, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 2023-09-13 14:33:29 
 */
class P354_RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new P354_RussianDollEnvelopes().new Solution();
        int[][] res = {{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}};
        int len = solution.maxEnvelopes(res);

    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 按宽度升序排序，若宽度相等，按高度降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]
                        ? o2[1] - o1[1]
                        : o1[0] - o2[0];
            }
        });

        // 对高度 最长递增子序列
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return lengOfLIS2(height);

    }
        private int lengOfLIS(int[] height) {
            int[] result = new int[height.length + 1];
            // 牌堆数
            int size = 0;

            for (int i = 0; i < height.length; i++) {
                // 对于每个数 在result中找到对应的位置
                int target = height[i];

                int left = 0, right = size;
                while (left < right) {

                    int mid = left + (right - left)/2;
                    if (result[mid] == target) {
                        right = mid;
                    } else if (result[mid] > target) {
                        right = mid;
                    } else if (result[mid] < target) {
                        left = mid + 1;
                    }
                }
                // 对left 进行判断
                if (left == size) {
                    size++;
                }
                result[left] = target;
            }
            return size;

        }
        private int lengOfLIS2(int[] height) {

            int[] result = new int[height.length + 1];
            // 牌堆数
            // 初始化0的位置
            result[0] = height[0];
            int size = 1;

            for (int i = 1; i < height.length; i++) {
                // 对于每个数 在result中找到对应的位置
                int left = 0, right = size - 1;
                int target = height[i];
                while (left <= right) {

                    int mid = left + (right - left)/2;
                    if (result[mid] == target) {
                        right = mid - 1;
                    } else if (result[mid] > target) {
                        right = mid - 1;
                    } else if (result[mid] < target) {
                        left = mid + 1;
                    }
                }
                // 对left 进行判断
                if (left == size) {
                    size++;
                }
                result[left] = target;
            }
            return size;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
