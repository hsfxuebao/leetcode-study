package leetcode.editor.cn;

//f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。 
//
// 
// 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。 
// 
//
// 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 0
//输出：5
//解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
// 
//
// 示例 2： 
//
// 
//输入：k = 5
//输出：0
//解释：没有匹配到这样的 x!，符合 k = 5 的条件。 
//
// 示例 3: 
//
// 
//输入: k = 3
//输出: 5
// 
//
// 
//
// 提示: 
//
// 
// 0 <= k <= 109 
// 
// Related Topics 数学 二分查找 
// 👍 195 👎 0

/**
 * 阶乘函数后 K 个零
 *
 * @author hsfxuebao
 * 2023-01-12 10:34:22 
 */
class P793_PreimageSizeOfFactorialZeroesFunction{
    public static void main(String[] args) {
        Solution solution = new P793_PreimageSizeOfFactorialZeroesFunction().new Solution();
        solution.rightBound(2);
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int preimageSizeFZF(int k) {

        return (int)(rightBound(k) - leftBound(k) + 1);

    }

        // 左侧边界
        public long leftBound(int k) {
            long left = 0, right = Long.MAX_VALUE;
            while (left < right) {

                long mid = left + (right - left) /2;
                if (trailingZeroes(mid) > k) {
                    right = mid;
                } else if (trailingZeroes(mid) < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

            }
            return left;
        }

        // 右侧边界
        private long rightBound(int k) {

            long left = 0, right = Long.MAX_VALUE;
            while (left < right) {
                long mid = left + (right - left) /2;
                if (trailingZeroes(mid) > k) {
                    right = mid;
                } else if (trailingZeroes(mid) < k) {
                    left = mid + 1;
                } else if (trailingZeroes(mid) == k){
                    left = mid + 1;
                }
            }
            // 判断一下 left-1 是否越界
            return left - 1;
        }


        /**
         * 数字n 的阶乘末尾 0 的个数
         */
        public long trailingZeroes(long n) {
            long res = 0;
            long divisor = 5;
            while (divisor <= n) {
                res += n / divisor;
                divisor *= 5;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
