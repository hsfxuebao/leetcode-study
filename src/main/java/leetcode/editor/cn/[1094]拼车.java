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
// 1 <= capacity <= 105 
// 
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 
// 👍 220 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1094 {

    public static boolean carPooling(int[][] trips, int capacity) {

        // 最多有1001个车站
        int[] nums = new int[1001];
        // 构造 差分数组
        final Difference difference = new Difference(nums);
        for (int[] update : trips) {
            // 乘客数量
            int val = update[0];
            // 第 trip[1] 站乘客上车
            int i = update[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = update[2] - 1;
            // 进行区间操作
            difference.increment(i, j, val);
        }
        int[] result = difference.result();
        // 客车自始至终都不应该超载
        for (int i = 0; i < result.length; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,5,7}};
        boolean b = carPooling(trips, 3);
        System.out.println(b);
    }

}

/**
 * 差分数组 工具类
 */
class Difference {

    // 差分数组
    private int[] diff;

    /* 输入一个初始数组，区间操作将在这个数组上进行 */
    public Difference(int[] nums) {

        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间 [i, j] 增加 val（可以是负数）*/
    public void increment(int i, int j, int val) {

        // 给左边加val
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }

    }

    // 最终返回的数组
    public int[] result() {

        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {

            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }


}

//leetcode submit region end(Prohibit modification and deletion)
