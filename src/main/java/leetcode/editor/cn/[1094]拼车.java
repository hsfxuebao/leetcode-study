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
// 👍 239, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 拼车
 *
 * @author hsfxuebao
 * 2023-04-15 21:46:42 
 */
class P1094_CarPooling{
    public static void main(String[] args) {
        Solution solution = new P1094_CarPooling().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference difference = new Difference(nums);
        for (int[] trip:trips) {
            int i = trip[1];
            int j = trip[2] - 1;
            int val = trip[0];
            difference.increment(i, j, val);
        }
        int[] result = difference.getResult();
        for (Integer res : result) {
            if (res > capacity) {
                return false;
            }
        }
        return true;
    }
}

    /**
     * 差分数组工具类
     */
    class Difference {

        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }
        /* 给闭区间 [i, j] 增加 val（可以是负数）*/
        public void increment(int i, int j, int val) {

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

//leetcode submit region end(Prohibit modification and deletion)
 
}
