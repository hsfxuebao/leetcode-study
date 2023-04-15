package leetcode.editor.cn;

//这里有 n 个航班，它们分别从 1 到 n 进行编号。 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
//
// Related Topics数组 | 前缀和 
//
// 👍 456, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 航班预订统计
 *
 * @author hsfxuebao
 * 2023-04-15 21:33:19 
 */
class P1109_CorporateFlightBookings{
    public static void main(String[] args) {
        Solution solution = new P1109_CorporateFlightBookings().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] nums = new int[n];

        Difference difference = new Difference(nums);
        for (int[] booking:bookings) {
            int i = booking[0] -1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.increment(i, j, val);
        }
        return difference.getResult();

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
