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
// 0 <= k <= 10⁹ 
// 
//
// Related Topics数学 | 二分查找 
//
// 👍 198, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 阶乘函数后 K 个零
 *
 * @author hsfxuebao
 * 2023-04-02 16:07:53 
 */
class P793_PreimageSizeOfFactorialZeroesFunction{
    public static void main(String[] args) {
        Solution solution = new P793_PreimageSizeOfFactorialZeroesFunction().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int preimageSizeFZF(int k) {
        return (int)(rightBound(k) - leftBound(k) + 1);

    }

        private long leftBound(long k) {
            long left = 0, right = Long.MAX_VALUE;

            while (left < right) {
                long mid = left + (right - left)/2;

                if (trailingZeroes(mid) > k) {
                    right = mid;
                } else if (trailingZeroes(mid) < k) {
                    left = mid + 1;
                } else if (trailingZeroes(mid) == k) {
                    right = mid;
                }
            }
            return left;
        }

        private long rightBound(int k) {
            long left = 0, right = Long.MAX_VALUE;

            while (left < right) {
                long mid = left + (right - left)/2;

                if (trailingZeroes(mid) > k) {
                    right = mid;
                } else if (trailingZeroes(mid) < k) {
                    left = mid + 1;
                } else if (trailingZeroes(mid) == k) {
                    left = mid + 1;
                }
            }
            return left -1;
        }

        private long trailingZeroes(long n) {
        long res = 0;
        for (long i = n; i / 5 > 0; i = i / 5) {

            res += i / 5;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
