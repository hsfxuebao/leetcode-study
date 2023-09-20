package leetcode.editor.cn;

//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列） 
//
// 👍 275, 👎 0 
//
//
//
//

/**
 * 拼车
 *
 * @author hsfxuebao
 * 2023-09-20 10:03:12 
 */
class P1094_CarPooling{
    public static void main(String[] args) {
        Solution solution = new P1094_CarPooling().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[10001];
        Difference difference = new Difference(nums);
        for (int i = 0; i < trips.length; i++) {
            int left = trips[i][1];
            int right = trips[i][2] - 1;

            difference.incr(left, right, trips[i][0]);
        }
        int[] result = difference.getResult();
        for (int j = 0; j < result.length; j++) {
            if (result[j] > capacity) {
                return false;
            }
        }
        return true;

    }


        public class Difference {

            int[] diff;

            public Difference(int[] nums) {
                diff = new int[nums.length];
                diff[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    diff[i] = nums[i] - nums[i-1];
                }
            }

            // 针对[i,j] 闭区间增加val
            public void incr(int i, int j, int val) {

                diff[i] += val;
                if (j + 1 < diff.length) {
                    diff[j+1] -= val;
                }
            }

            public int[] getResult() {
                int[] result = new int[diff.length];
                result[0] = diff[0];
                for (int i = 1; i < diff.length; i++) {
                    result[i] = diff[i] + result[i-1];
                }
                return result;
            }

        }


}
//leetcode submit region end(Prohibit modification and deletion)
 
}
