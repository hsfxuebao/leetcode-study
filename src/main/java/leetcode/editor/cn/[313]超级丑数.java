package leetcode.editor.cn;

//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。 
//
// 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。 
//
// 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12, primes = [2,7,13,19]
//输出：32 
//解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
//28,32] 。 
//
// 示例 2： 
//
// 
//输入：n = 1, primes = [2,3,5]
//输出：1
//解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
// 
//
// 
//
// 
// 
// 
// 提示： 
// 
// 
// 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// 题目数据 保证 primes[i] 是一个质数 
// primes 中的所有值都 互不相同 ，且按 递增顺序 排列 
// 
//
// Related Topics数组 | 数学 | 动态规划 
//
// 👍 386, 👎 0 
//
//
//
//

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 超级丑数
 *
 * @author hsfxuebao
 * 2023-09-18 14:40:46 
 */
class P313_SuperUglyNumber{
    public static void main(String[] args) {
        Solution solution = new P313_SuperUglyNumber().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        Queue<UglyNumber> queue = new PriorityQueue<>(new Comparator<UglyNumber>() {
            @Override
            public int compare(UglyNumber o1, UglyNumber o2) {
                return o1.getNum() - o2.getNum();
            }
        });
        for (int i = 0; i < primes.length; i++) {
            queue.offer(new UglyNumber(1, primes[i], 1));
        }

        int[] ugly = new int[n+1];
        int p = 1;
        while (p <= n) {
            UglyNumber poll = queue.poll();
            ugly[p] = poll.getNum();
            p++;
            // 全部出队列，重新入队
            int index = poll.getIndex();
            int prime = poll.getPrime();
            // 放入下一个数
            queue.offer(new UglyNumber(prime * ugly[index], prime, index+1));

            for (int i = 0; i < queue.size(); i++) {
                UglyNumber queuePoll = queue.poll();
                if (queuePoll.getNum() == poll.getNum()) {
                    int num = queuePoll.getNum();
                    int index1 = queuePoll.getIndex();
                    int prime1 = queuePoll.getPrime();
                    queue.offer(new UglyNumber(prime1 * ugly[index1], prime1, index1+1));
                } else {
                    queue.offer(queuePoll);
                }

            }
        }

        return ugly[n];
    }

        public class UglyNumber {
            int num;  // 排序的数值
            int prime; // 质数
            int index; // 索引


            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getPrime() {
                return prime;
            }

            public void setPrime(int prime) {
                this.prime = prime;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public UglyNumber(int num, int prime, int index) {
                this.num = num;
                this.prime = prime;
                this.index = index;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
