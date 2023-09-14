package leetcode.editor.cn;

//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 537, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 爱吃香蕉的珂珂
 *
 * @author hsfxuebao
 * 2023-09-14 11:42:49 
 */
class P875_KokoEatingBananas{
    public static void main(String[] args) {
        Solution solution = new P875_KokoEatingBananas().new Solution();
        int[] res = {805306368,805306368,805306368};
        solution.minEatingSpeed(res, 1000000000);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // x轴 : 吃香蕉的速度
        // y轴 ：小时数
        // 变量x 为 吃香蕉的速度
//        int left = 1;
//        // 最大速度 + 1
//        int right = 1000000000 + 1;
//        while (left < right) {
//            int mid = left + (right - left)/2;
//
//            if (needHours(piles, mid) > h) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;

        int left = 1, right = 1000000000;
//        for (int pile : piles) {
//            right = Math.max(right, pile);
//        }
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (needHours(piles, mid) < h) {
                right = mid-1;
            } else if (needHours(piles, mid) > h) {
                left = mid + 1;
            } else if (needHours(piles, mid) == h) {
                right = mid-1;
            }
        }
        return left;
    }

        private long needHours(int[] piles, int x) {
            long hours = 0;
//            for (int pile : piles) {
//                count += pile / num;
//                if (pile % num > 0) {
//                    count++;
//                }
//            }
            for (int i = 0; i < piles.length; i++) {
                hours += piles[i] / x;
                if (piles[i] % x > 0) {
                    hours++;
                }
            }
            return hours;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
