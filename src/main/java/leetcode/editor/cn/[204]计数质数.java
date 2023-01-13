package leetcode.editor.cn;

//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
//
// Related Topics数组 | 数学 | 枚举 | 数论 
//
// 👍 999, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;

/**
 * 计数质数
 *
 * @author hsfxuebao
 * 2023-01-13 20:59:59 
 */
class P204_CountPrimes{
    public static void main(String[] args) {
        Solution solution = new P204_CountPrimes().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {

        boolean[] isPrime = new boolean[n];
        // 初始化 都是true 都是素数
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    // i 的倍数不可能是素数了
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }
        return cnt;
    }


        // 判断整数 n 是否是素数
        boolean isPrime(int n) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0){
                    // 有其他整除因子
                    return false;
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
