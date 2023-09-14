package leetcode.editor.cn;

//传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。 
//
// 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最
//大运载重量。 
//
// 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。 
//
// 
//
// 示例 1： 
//
// 
//输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
//0) 是不允许的。 
// 
//
// 示例 2： 
//
// 
//输入：weights = [3,2,2,4,1,4], days = 3
//输出：6
//解释：
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
// 
//
// 示例 3： 
//
// 
//输入：weights = [1,2,3,1,1], days = 4
//输出：3
//解释：
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= days <= weights.length <= 5 * 10⁴ 
// 1 <= weights[i] <= 500 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 557, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 在 D 天内送达包裹的能力
 *
 * @author hsfxuebao
 * 2023-09-14 11:32:43 
 */
class P1011_CapacityToShipPackagesWithinDDays{
    public static void main(String[] args) {
        Solution solution = new P1011_CapacityToShipPackagesWithinDDays().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shipWithinDays(int[] weights, int days) {


        // 二分，左侧边界
        int left = 0, right = 0;
        // 最小运载能力为 单次最大货物，最大运载能力为所有货物一次运输完
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (needDays(weights, mid) > days) {
                left = mid + 1;
            } else if (needDays(weights, mid) < days) {
                right = mid - 1;

            } else if (needDays(weights, mid) == days) {
                right = mid - 1;
            }
        }

        return left;
    }

        // 单次运载能力
        private int needDays(int[] weights, int mid) {
            // 按顺序运输
            int days = 1;
            int cap = mid;
            for (int weight : weights) {
                if (cap - weight < 0) {
                    days++;
                    cap = mid;
                }
                cap = cap - weight;
            }
            return days;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
